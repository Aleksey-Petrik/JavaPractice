package academy.kovalevskyi.javadeepdive.week2.day0;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class JsonHelper {

  public static <T> String toJsonString(T target) throws IllegalAccessException {
    if (target == null) {
      return "null";
    }
    if (target instanceof Integer || target instanceof String) {
      return valueForJson(target);
    } else if (target.getClass().isArray()) {
      return arrayToJsonString(target);
    } else {
      StringBuilder jsonLine = new StringBuilder("{");
      for (Field field : target.getClass().getDeclaredFields()) {
        field.setAccessible(true);
        Object object = field.get(target);

        jsonLine.append(jsonLine.length() > 1 ? "," : "")
                .append(valueForJson(field))
                .append(object.getClass().isArray() ? arrayToJsonString(object) : valueForJson(object));
      }
      jsonLine.append("}");

      return jsonLine.toString();
    }
  }

  public static <T> T fromJsonString(String json, Class<T> cls)
          throws IllegalAccessException, InvocationTargetException, InstantiationException,
          NoSuchFieldException, NoSuchMethodException {

    if (json == null || json.matches("^\\s*((\\{\\s*})|(null|NULL))*\\s*$")) {
      return null;
    }

    if (json.startsWith("[") && json.length() > 2) {
      return jsonToArray(splitJson(json), cls);
    }

    if (json.startsWith("{") && json.length() > 2) {
      return jsonToObject(splitJson(json), cls);
    }

    return (T) Array.newInstance(cls.getComponentType(), 0);
  }

  private static String[] splitJson(String json) {
    return json.substring(1, json.length() - 1)
            .replace("\"", "")
            .split(",");
  }

  private static String valueForJson(Object value) {
    if (value instanceof Field) {
      return String.format("\"%s\":", ((Field) value).getName());
    } else if (value instanceof String) {
      return String.format("\"%s\"", value);
    }
    return value.toString();
  }

  private static String arrayToJsonString(Object object) {
    int length = Array.getLength(object);
    StringBuilder jsonLine = new StringBuilder("[");
    for (int i = 0; i < length; i++) {
      jsonLine.append(i > 0 ? "," : "")
              .append(valueForJson(Array.get(object, i)));
    }
    jsonLine.append("]");
    return jsonLine.toString();
  }

  private static <T> T jsonToArray(String[] jsonElements, Class<T> clazz) {
    T resultArray = (T) Array.newInstance(clazz.getComponentType(), jsonElements.length);
    for (int i = 0; i < jsonElements.length; i++) {
      Array.set(resultArray, i, clazz.getComponentType().equals(int.class) ? Integer.parseInt(jsonElements[i]) : jsonElements[i]);
    }
    return resultArray;
  }

  private static <T> T jsonToObject(String[] jsonElements, Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
    T object = clazz.getConstructor().newInstance();
    for (String element : jsonElements) {
      String[] nameAndValue = element.replace("'", "").split(":");
      Field field = object.getClass().getDeclaredField(nameAndValue[0].trim());
      field.setAccessible(true);
      field.set(object, field.getType().equals(String.class) ? nameAndValue[1].trim()
              : Integer.parseInt(nameAndValue[1].trim()));
    }
    return object;
  }

}