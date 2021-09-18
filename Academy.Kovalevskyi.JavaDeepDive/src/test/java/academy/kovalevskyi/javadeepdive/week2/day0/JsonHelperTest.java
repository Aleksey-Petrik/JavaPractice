package academy.kovalevskyi.javadeepdive.week2.day0;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

class JsonHelperTest {

  @Test
  void toJsonStringInString() throws NoSuchFieldException, IllegalAccessException {
    String strLine = "one";
    String strLine2 = "one two";
    String[] strLine3 = new String[]{"one", "two", "four", "five"};
    Truth.assertWithMessage("Error").that(JsonHelper.toJsonString(strLine)).isEqualTo("\"one\"");
    Truth.assertWithMessage("Error").that(JsonHelper.toJsonString(strLine2)).isEqualTo("\"one two\"");
    Truth.assertWithMessage("Error").that(JsonHelper.toJsonString(strLine3)).isEqualTo("[\"one\",\"two\",\"four\",\"five\"]");
  }

  @Test
  void toJsonStringInInteger() throws NoSuchFieldException, IllegalAccessException {
    int number = 6;
    int number2 = -5;
    int[] numbers = new int[]{1, 2, 3, 4, 5};
    Truth.assertWithMessage("Error").that(JsonHelper.toJsonString(number)).isEqualTo("6");
    Truth.assertWithMessage("Error").that(JsonHelper.toJsonString(number2)).isEqualTo("-5");
    Truth.assertWithMessage("Error").that(JsonHelper.toJsonString(numbers)).isEqualTo("[1,2,3,4,5]");
  }

  @Test
  void toJsonStringInObject() throws NoSuchFieldException, IllegalAccessException {
    SimpleOneStringClass object = new SimpleOneStringClass();
    Truth.assertWithMessage("Error")
            .that(JsonHelper.toJsonString(object))
            .isEqualTo("{\"one\":\"_ololo1_\",\"two\":\"xaxa\",\"second\":[1,2,3,4,6],\"second2\":[\"one\",\"two\",\"four\",\"five\"]}");
  }

  @Test
  void fromJsonString() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {

    Truth.assertWithMessage("Error")
            .that(JsonHelper.fromJsonString("[7,-7]", int[].class))
            .isEqualTo(new int[]{7, -7});

    Truth.assertWithMessage("Error")
            .that(JsonHelper.fromJsonString("[\"one\",\"two\"]", String[].class))
            .isEqualTo(new String[]{"one", "two"});

    Truth.assertWithMessage("Error")
            .that(JsonHelper.fromJsonString("{\"one\":\"_ololo1_\",\"two\":\"2525252\",\"oneInt\":99,\"twoInt\":6969}", SimpleStringIntegerClass.class))
            .isEqualTo(new SimpleStringIntegerClass("_ololo1_", "2525252", 99, 6969));

  }
}