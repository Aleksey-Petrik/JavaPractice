package academy.kovalevskyi.javadeepdive.week1.day1;

import academy.kovalevskyi.javadeepdive.week1.day0.HttpRequestsHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHttpServer implements Runnable {
  private static final int PORT = 8080;
  private boolean live = true;
  private ServerSocket serverSocket;

  private final ExecutorService executorService = Executors.newFixedThreadPool(10);

  public static void main(String[] args) {

    var server = new ConcurrentHttpServer();
    var thread = new Thread(server);
    thread.start();
    System.out.println("Server - " + server.isLive());

    System.out.print("input 'stop' to stop the server: ");
    while (!"stop".equals((new Scanner(System.in)).next())) {
      System.out.println("Server - " + server.isLive());
    }
    server.stop();
    System.out.println("Server - " + server.isLive());
  }

  @Override
  public void run() {
    try (var serverSocket = new ServerSocket(PORT)) {
      this.serverSocket = serverSocket;
      while (live) {
        final Socket socketClient = serverSocket.accept();
        executorService.execute(() -> {
          try (Socket threadSocket = socketClient) {
            new HttpRequestsHandler(threadSocket).executeRequest();
          } catch (IOException e) {
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

  public void stop() {
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