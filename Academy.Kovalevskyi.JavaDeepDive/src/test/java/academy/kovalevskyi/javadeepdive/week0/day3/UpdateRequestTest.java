package academy.kovalevskyi.javadeepdive.week0.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;
import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class UpdateRequestTest {

  @Test
  void execute() {
    String[] header = {"name", "birthday_year", "comment"};
    String[][] body = {
            {"Slava", "1987", "lol"},
            {"Gleb", "1980", "rrr"},
            {"Serega", "1987", "rrrrlolo3"},
            {"Anton", "1970", "rrr"},
            {"Fill", "1987", "lol"},
            {"Lex", "1987", "ololo3"},
            {"Soer", "1987", "llo3"},
    };
    Selector selector = new Selector("birthday_year", "1987");
    Selector selectorUpdate = new Selector("comment", "ololo3");
    String[][] result = {
            {"Slava", "1987", "ololo3"},
            {"Gleb", "1980", "rrr"},
            {"Serega", "1987", "ololo3"},
            {"Anton", "1970", "rrr"},
            {"Fill", "1987", "ololo3"},
            {"Lex", "1987", "ololo3"},
            {"Soer", "1987", "ololo3"},
    };
    Csv csv = new Csv(header, body);
    var request = new UpdateRequest.Builder().from(csv).where(selector).update(selectorUpdate).build();
    try {
      var actual = request.execute();
      System.out.println(Arrays.deepToString(actual.values()));
      Truth.assertWithMessage("No").that(actual.values()).isEqualTo(result);
    } catch (RequestException e) {
      e.printStackTrace();
    }
  }
}
