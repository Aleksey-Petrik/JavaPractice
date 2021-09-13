package academy.kovalevskyi.javadeepdive.week0.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;
import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;

public class InsertRequestTest {

  @Test
  void execute() {
    String[] header = {"name", "birthday_year", "comment"};
    String[][] body = {
            {"Slava", "1987", "ololo"},
            {"Gleb", "1985", "ololo2"},
            {"Serega", "1987", "ololo3"}};
    String[] line = {"Anton", "1977", "olo"};
    String[][] result = {
            {"Slava", "1987", "ololo"},
            {"Gleb", "1985", "ololo2"},
            {"Serega", "1987", "ololo3"},
            {"Anton", "1977", "olo"}};

    Csv csv = new Csv(header, body);
    var request = new InsertRequest.Builder().to(csv).insert(line).build();
    try {
      var actual = request.execute();
      Truth.assertWithMessage("No").that(actual.values()).isEqualTo(result);
    } catch (RequestException e) {
      e.printStackTrace();
    }
  }
}
