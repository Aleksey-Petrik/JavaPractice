package academy.kovalevskyi.javadeepdive.week1.day2;

public enum HttpVersion {
  HTTP_0_9("HTTP/0.9"),
  HTTP_1_0("HTTP/1.0"),
  HTTP_1_1("HTTP/1.1"),
  HTTP_2_0("HTTP/2.0");

  private final String version;

  HttpVersion(String version) {
    this.version = version;
  }

  public String getVersion() {
    return version;
  }

}