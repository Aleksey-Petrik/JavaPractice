package academy.kovalevskyi.javadeepdive.week0.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;
import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class JoinRequestTest {

  @Test
  void execute() {
    Csv csv = new Csv.Builder()
            .header(new String[]{"id", "name", "birthday_year", "comment"})
            .values(new String[][]{
                    {"0", "Slava", "1987", "ololo"},
                    {"1", "Gleb", "1985", "ololo2"},
                    {"2", "Serega", "1987", "ololo3"}})
            .build();
    Csv csv2 = new Csv.Builder().header(new String[]{"id", "own"})
            .values(new String[][]{
                    {"0", "12"},
                    {"1", "11"},
                    {"2", "200"}})
            .build();
  }

  @Test
  void executeJoin() {
    String[] headerFrom = {"id", "name", "birthday_year", "comment"};
    String[][] bodyFrom = {{"0", "Slava", "1987", "ololo"},
            {"1", "Gleb", "1985", "ololo2"},
            {"2", "Serega", "1987", "ololo3"}};

    String[] headerOn = {"id", "own"};
    String[][] bodyOn = {{"0", "12"},
            {"1", "11"},
            {"2", "200"}};

    String by = "id";

    String[] headerResult = {"id", "name", "birthday_year", "comment", "own"};
    String[][] bodyResult = {{"0", "Slava", "1987", "ololo", "12"},
            {"1", "Gleb", "1985", "ololo2", "11"},
            {"2", "Serega", "1987", "ololo3", "200"}};


    Csv csvFrom = new Csv(headerFrom, bodyFrom);
    Csv csvOn = new Csv(headerOn, bodyOn);
    Csv csvResult = new Csv(headerResult, bodyResult);

    var request = new JoinRequest.Builder().from(csvFrom).on(csvOn).by(by).build();
    try {
      Csv actual = request.execute();
      System.out.println(Arrays.toString(actual.header()));
      System.out.println(Arrays.deepToString(actual.values()));
      Truth.assertWithMessage("No").that(actual).isEqualTo(csvResult);
    } catch (RequestException e) {
      e.printStackTrace();
    }
  }

}