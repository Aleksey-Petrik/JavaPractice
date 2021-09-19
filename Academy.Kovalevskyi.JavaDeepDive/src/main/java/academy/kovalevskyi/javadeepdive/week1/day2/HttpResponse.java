package academy.kovalevskyi.javadeepdive.week1.day2;

public record HttpResponse(ResponseStatus status, ContentType contentType, String body, HttpVersion httpVersion) {

  public final static HttpResponse ERROR_404 =
          new Builder().status(ResponseStatus.ERROR_404).build();
  public final static HttpResponse OK_200 =
          new Builder().status(ResponseStatus.OK).build();
  public final static HttpResponse ERROR_500 =
          new Builder().status(ResponseStatus.ERROR_500).build();

  public static class Builder {
    private ResponseStatus status = ResponseStatus.OK;
    private ContentType contentType = ContentType.TEXT_HTML;
    private String body = "";
    private HttpVersion version = HttpVersion.HTTP_1_1;

    public Builder status(ResponseStatus status) {
      this.status = status;
      return this;
    }

    public Builder contentType(ContentType contentType) {
      this.contentType = contentType;
      return this;
    }

    public Builder body(String body) {
      this.body = body;
      return this;
    }

    public Builder httpVersion(HttpVersion version) {
      this.version = version;
      return this;
    }

    public HttpResponse build() {
      return new HttpResponse(status, contentType, body, version);
    }
  }

  public enum ResponseStatus {
    OK(200, "OK"),
    ERROR_404(404, "not found"),
    ERROR_500(500, "server error");

    public final int code;
    public final String status;

    ResponseStatus(int code, String note) {
      this.code = code;
      this.status = note;
    }

    public int getCode() {
      return code;
    }

    public String getNote() {
      return status;
    }
  }
}
