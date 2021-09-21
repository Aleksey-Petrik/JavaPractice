package academy.kovalevskyi.javadeepdive.week1.day2;

import academy.kovalevskyi.javadeepdive.week0.day3.RequestException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHttpServerWithPath extends Thread {
  private static final int PORT = 8080;
  private boolean live = true;
  private ServerSocket serverSocket;
  private final CopyOnWriteArrayList<HttpRequestsHandler> handlers = new CopyOnWriteArrayList<>();

  private final ExecutorService executorService = Executors.newFixedThreadPool(10);

  public static void main(String[] args) {
    var server = new ConcurrentHttpServerWithPath();
    server.addHandler(new HttpRequestsHandler() {
      @Override
      public String path() {
        return "/hi";
      }

      @Override
      public HttpMethod method() {
        return HttpMethod.GET;
      }

      @Override
      public HttpResponse process(HttpRequest request) {
        return new HttpResponse.Builder().body("<h1>HI!</h1>").build();
      }
    });
    server.start();
  }

  public void addHandler(HttpRequestsHandler handler) {
    handlers.add(handler);
  }

  public void run() {
    try (var serverSocket = new ServerSocket(PORT)) {
      this.serverSocket = serverSocket;
      while (live) {
        final Socket socketClient = serverSocket.accept();
        executorService.execute(() -> {
          try (Socket threadSocket = socketClient) {
            boolean isPage404 = true;
            var inRequest = HttpHelper.readInputStream(threadSocket.getInputStream());

            for (var handler : handlers) {
              if (handler.method().equals(inRequest.httpMethod())
                      && handler.path().equals(inRequest.path())) {
                var outRequest = handler.process(inRequest);
                HttpHelper.writeOutputStream(outRequest, threadSocket.getOutputStream());
                isPage404 = false;
                break;
              }
            }

            if (isPage404) {
              HttpHelper.writeOutputStream(HttpResponse.ERROR_404, threadSocket.getOutputStream());
            }

          } catch (IOException | RequestException e) {
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
  }

  public boolean isLive() {
    return live;
  }
}
