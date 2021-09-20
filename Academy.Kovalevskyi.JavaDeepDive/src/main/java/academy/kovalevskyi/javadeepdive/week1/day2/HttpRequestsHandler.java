package academy.kovalevskyi.javadeepdive.week1.day2;

import academy.kovalevskyi.javadeepdive.week0.day3.RequestException;

public interface HttpRequestsHandler {
  String path();

  HttpMethod method();

  HttpResponse process(HttpRequest request) throws RequestException;
}
