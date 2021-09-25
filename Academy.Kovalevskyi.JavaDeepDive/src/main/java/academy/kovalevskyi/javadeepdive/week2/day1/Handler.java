package academy.kovalevskyi.javadeepdive.week2.day1;

import academy.kovalevskyi.javadeepdive.week1.day2.HttpMethod;

import java.lang.reflect.Method;

public class Handler {
  private final String httpPath;
  private final HttpMethod httpMethod;
  private final Object object;
  private final Method methodObject;

  private Handler(HandlerBuilder handlerBuilder) {
    this.httpPath = handlerBuilder.httpPath;
    this.httpMethod = handlerBuilder.httpMethod;
    this.object = handlerBuilder.object;
    this.methodObject = handlerBuilder.methodObject;
  }

  public String getHttpPath() {
    return httpPath;
  }

  public HttpMethod getHttpMethod() {
    return httpMethod;
  }

  public Object getObject() {
    return object;
  }

  public Method getMethodObject() {
    return methodObject;
  }

  public static class HandlerBuilder {
    private String httpPath;
    private HttpMethod httpMethod;
    private Object object;
    private Method methodObject;

    public String getPath() {
      return httpPath;
    }

    public HttpMethod getHttpMethod() {
      return httpMethod;
    }

    public Object getObject() {
      return object;
    }

    public Method getMethodObject() {
      return methodObject;
    }

    public HandlerBuilder path(String httpPath) {
      this.httpPath = httpPath;
      return this;
    }

    public HandlerBuilder httpMethod(HttpMethod httpMethod) {
      this.httpMethod = httpMethod;
      return this;
    }

    public HandlerBuilder object(Object object) {
      this.object = object;
      return this;
    }

    public HandlerBuilder methodObject(Method methodObject) {
      this.methodObject = methodObject;
      return this;
    }

    public Handler builder() {
      return new Handler(this);
    }
  }

}
