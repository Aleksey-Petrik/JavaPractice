package academy.kovalevskyi.javadeepdive.week1.day2;

import academy.kovalevskyi.javadeepdive.week0.day0.StdBufferedReader;
import academy.kovalevskyi.javadeepdive.week0.day0.StdBufferedReader2;

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
    var bufferedReader = new StdBufferedReader2(new InputStreamReader(in));
    var requestBuilder = new StringBuilder();

    String strLine;
    while (!(strLine = new String(bufferedReader.readLine())).isBlank()) {
      requestBuilder.append(strLine).append("\r\n");
    }

    String request = requestBuilder.toString();
    String[] requestsLines = request.split("\r\n");
    String[] requestLine = requestsLines[0].split(" ");
    String httpPath = requestLine[1].trim();
    String http = requestLine[2].trim();

    HttpMethod httpMethod = HttpMethod.valueOf(requestLine[0].trim());
    HttpVersion httpVersion = HttpVersion.valueOf(http.trim().replace("/", "_")
            .replace(".", "_"));

    String body2 = "";
    if (bufferedReader.hasNext()) {
      body2 = new String(bufferedReader.readLine());
    }

    return new HttpRequest.Builder().path(httpPath).body(body2).method(httpMethod).httpVersion(httpVersion).build();
  }

  private static String getBody(HttpResponse request) {
    StringBuilder bodyBuilder = new StringBuilder();
    // TODO: 25.09.2021 убрав 4 байта тесты зевса стали проходить, в противном случае брались лишние символы
    //int length = !request.body().isEmpty() ? request.body().length() + 4 : 0;
    int length = !request.body().isEmpty() ? request.body().length() : 0;
    bodyBuilder.append(String.format("Content-Length: %d\r\n", length))
            .append("\r\n")
            .append(length > 0 ? request.body() + "\r\n\r\n" : "");
    return bodyBuilder.toString();
  }
}
