package academy.kovalevskyi.javadeepdive.week1.day0;

import academy.kovalevskyi.javadeepdive.week0.day0.StdBufferedReader;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpRequestsHandler {

  protected Socket socket;

  public HttpRequestsHandler(Socket socket) {
    this.socket = socket;
  }

  public void executeRequest() {
    try {
      inHandler(socket.getInputStream());
      outHandler(socket.getOutputStream());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void inHandler(InputStream inputStream) throws IOException {
    var bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    var sb = new StringBuilder();

    String strLine;
    while (!(strLine = (bufferedReader.readLine())).isEmpty()) {
      sb.append(strLine).append("\r\n");
    }
    /*
    while (bufferedReader.ready()) {
      sb.append(bufferedReader
              .readLine())
              .append("\r\n");
      System.out.println("hi");
    }
     */
    System.out.println(sb);
  }

  private void outHandler(OutputStream output) throws IOException {
    output.write("""
            HTTP/1.1 200 OK\r
            Content-Length: 20\r
            Content-Type: text/html\r
            \r
            <b>It works!</b>\r
            \r
            """.getBytes(StandardCharsets.UTF_8));
    output.flush();
  }
}