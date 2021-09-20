package academy.kovalevskyi.javadeepdive.week1.day2;

public enum ContentType {
  TEXT_HTML("text/html"),
  APPLICATION_JSON("application/json");
  private final String contentType;

  ContentType(String representation) {
    this.contentType = representation;
  }

  public String getContentType() {
    return contentType;
  }

}