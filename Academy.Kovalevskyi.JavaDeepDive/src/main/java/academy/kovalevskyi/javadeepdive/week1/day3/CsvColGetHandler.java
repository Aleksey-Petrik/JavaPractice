package academy.kovalevskyi.javadeepdive.week1.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;
import academy.kovalevskyi.javadeepdive.week0.day3.RequestException;
import academy.kovalevskyi.javadeepdive.week0.day3.SelectRequest;
import academy.kovalevskyi.javadeepdive.week1.day2.*;

import java.util.Arrays;

public class CsvColGetHandler implements HttpRequestsHandler {
  private final Csv csv;
  private final String columnName;
  private final String path;

  public CsvColGetHandler(Csv csv, String columnName, String path) {
    System.out.println(Arrays.toString(csv.header()));
    System.out.println(Arrays.deepToString(csv.values()));
    this.csv = csv;
    this.columnName = columnName;
    this.path = path;
  }

  @Override
  public String path() {
    return path;
  }

  @Override
  public HttpMethod method() {
    return HttpMethod.GET;
  }

  @Override
  public HttpResponse process(HttpRequest request) throws RequestException {

    String[][] selectRequestData = new SelectRequest.Builder().from(csv).select(new String[]{columnName}).build().execute();

    StringBuilder json = new StringBuilder("[");
    for (String[] element : selectRequestData) {
      json.append(json.length() > 1 ? "," : "")
              .append(String.format("\"%s\"", element[0]));
    }
    json.append("]");
    return new HttpResponse.Builder().contentType(ContentType.APPLICATION_JSON).body(json.toString()).build();
  }

}
