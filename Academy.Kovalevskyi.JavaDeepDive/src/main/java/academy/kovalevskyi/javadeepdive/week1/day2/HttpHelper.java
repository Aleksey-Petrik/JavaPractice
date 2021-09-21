package academy.kovalevskyi.javadeepdive.week1.day2;

import academy.kovalevskyi.javadeepdive.week0.day0.StdBufferedReader;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class HttpHelper {

  public static void writeOutputStream(HttpResponse request, OutputStream out) throws IOException {

    String responseBuilder = String.format("%s %d %s\r\n",
            request.httpVersion().getVersion(),
            request.status().getCode(),
            request.status().getStatus()) +
            String.format("Content-Type: %s\r\n", request.contentType().getContentType()) +
            getBody(request);
    out.write(responseBuilder.getBytes(StandardCharsets.UTF_8));
    out.flush();
  }

  public static HttpRequest readInputStream(InputStream in) throws IOException {
    var bufferedReader = new BufferedReader(new InputStreamReader(in));
    var requestBuilder = new StringBuilder();

    String strLine;
    while (!(strLine = (bufferedReader.readLine())).isEmpty()) {
      requestBuilder.append(strLine).append("\r\n");
    }

    String request = requestBuilder.toString();
    System.out.println(request);
    String[] requestsLines = request.split("\r\n");
    String[] requestLine = requestsLines[0].split(" ");
    String methodStr = requestLine[0];
    String path = requestLine[1];
    String http = requestLine[2];

    HttpMethod httpMethod = HttpMethod.valueOf(methodStr);
    HttpVersion httpVersion = HttpVersion.valueOf(http.replace("/", "_")
            .replace(".", "_"));

    return new HttpRequest.Builder().path(path).method(httpMethod).httpVersion(httpVersion).build();
  }

  private static String getBody(HttpResponse request) {
    StringBuilder bodyBuilder = new StringBuilder();
    int length = !request.body().isEmpty() ? request.body().length() + 4 : 0;
    bodyBuilder.append(String.format("Content-Length: %d\r\n", length))
            .append("\r\n")
            .append(length > 0 ? request.body() + "\r\n\r\n" : "");
    return bodyBuilder.toString();
  }
}
