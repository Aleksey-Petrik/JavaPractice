package academy.kovalevskyi.javadeepdive.week1.day0;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class HttpServer implements Runnable {
  private static final int PORT = 8080;
  private boolean live = true;
  private ServerSocket serverSocket;

  public static void main(String[] args) {

    var server = new HttpServer();
    var thread = new Thread(server);
    thread.start();

    try (var scanner = new Scanner(System.in)) {
      do {
        System.out.print("\ninput 'stop' to stop the server: ");
        if ("stop".equals(scanner.next())) {
          server.stop();
          break;
        }
      } while (true);
    }
  }

  @Override
  public void run() {
    try (var serverSocket = new ServerSocket(PORT)) {
      this.serverSocket = serverSocket;
      while (live) {
        try (var socket = serverSocket.accept()) {
          new HttpRequestsHandler(socket).executeRequest();
        }
      }
    } catch (IOException e) {
      if (live) {
        e.printStackTrace();
      }
    }
  }

  public void stop() {
    live = false;
    try {
      serverSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean isLive() {
    return live;
  }
}