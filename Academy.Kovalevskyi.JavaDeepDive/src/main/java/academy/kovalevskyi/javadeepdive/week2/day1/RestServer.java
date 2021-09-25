package academy.kovalevskyi.javadeepdive.week2.day1;

import academy.kovalevskyi.javadeepdive.week1.day2.*;
import academy.kovalevskyi.javadeepdive.week2.day0.JsonHelper;
import org.reflections.Reflections;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RestServer extends Thread {
  private static final int PORT = 8080;
  private boolean live = true;
  private ServerSocket serverSocket;
  private final CopyOnWriteArrayList<Handler> handlers = new CopyOnWriteArrayList<>();
  private final ExecutorService executorService = Executors.newFixedThreadPool(10);

  public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    RestServer server = new RestServer("academy.kovalevskyi.javadeepdive.week2.day1");
    server.start();
  }

  public RestServer(String packagePath) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    Reflections reflections = new Reflections(packagePath);

    HttpMethod httpMethod = null;

    Set<Class<?>> setClazz = reflections.getTypesAnnotatedWith(Controller.class);
    for (Class<?> clazz : setClazz) {
      Object object = clazz.getDeclaredConstructor().newInstance();
      for (Method method : clazz.getMethods()) {
        if (method.getAnnotation(Path.class) != null) {
          if (method.getAnnotation(Get.class) != null) {
            httpMethod = HttpMethod.GET;
          }
          if (method.getAnnotation(Post.class) != null) {
            httpMethod = HttpMethod.POST;
          }
          if (method.getAnnotation(Put.class) != null) {
            httpMethod = HttpMethod.PUT;
          }
          if (method.getAnnotation(Delete.class) != null) {
            httpMethod = HttpMethod.DELETE;
          }

          var path = method.getAnnotation(Path.class).value();

          handlers.add(new Handler.HandlerBuilder()
                  .path(path)
                  .httpMethod(httpMethod)
                  .object(object)
                  .methodObject(method)
                  .builder());
        }
      }
    }

  }

  public void run() {
    try (var serverSocket = new ServerSocket(PORT)) {
      this.serverSocket = serverSocket;
      while (live) {
        final Socket socketClient = serverSocket.accept();
        executorService.execute(() -> {
          try (Socket threadSocket = socketClient) {
            boolean isPage404 = true;
            var inputRequest = HttpHelper.readInputStream(threadSocket.getInputStream());

            for (var handler : handlers) {
              if (handler.getHttpMethod().equals(inputRequest.httpMethod())
                      && handler.getHttpPath().equals(inputRequest.path())) {

                var parameterTypes = handler.getMethodObject().getParameterTypes();
                Object result;
                if (parameterTypes.length > 0) {
                  var parameterType = parameterTypes[0];
                  var inParam = JsonHelper.fromJsonString(inputRequest.body().get(), parameterType);
                  result = handler.getMethodObject().invoke(handler.getObject(), inParam);
                } else {
                  result = handler.getMethodObject().invoke(handler.getObject());
                }

                HttpResponse response;
                if (handler.getHttpMethod() == HttpMethod.GET) {
                  response = new HttpResponse.Builder()
                          .contentType(ContentType.APPLICATION_JSON)
                          .body(JsonHelper.toJsonString(result))
                          .build();

                } else {
                  response = new HttpResponse.Builder()
                          .body("<h1>User added!</h1>")
                          .build();
                }

                HttpHelper.writeOutputStream(response, threadSocket.getOutputStream());

                isPage404 = false;
                break;
              }
            }

            if (isPage404) {
              HttpHelper.writeOutputStream(HttpResponse.ERROR_404, threadSocket.getOutputStream());
            }

          } catch (Exception e) {
            e.printStackTrace();
          }
        });
      }
    } catch (IOException e) {
      if (live) {
        e.printStackTrace();
      }
      executorService.shutdown();
    }
  }

  public void stopServer() {
    live = false;
    try {
      executorService.shutdown();
      if (serverSocket != null) {
        serverSocket.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean isLive() {
    return live;
  }
}
