package academy.kovalevskyi.javadeepdive.week0.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;
import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;

class SelectRequestTest {

  @Test
  void execute() {
    String[] header = {"name", "birthday_year", "comment"};
    String[][] body = {
            {"Slava", "1987", "ololo"},
            {"Gleb", "1985", "ololo2"},
            {"Serega", "1987", "ololo3"}};
    String[] columns = {"name", "comment"};
    String[][] result = {
            {"Slava", "ololo"},
            {"Serega", "ololo3"}};

    Selector selector = new Selector.Builder().fieldName("birthday_year").value("1987").build();
    Csv csv = new Csv(header, body);
    var request = new SelectRequest.Builder().from(csv).where(selector).select(columns).build();
    try {
      var actual = request.execute();
      Truth.assertWithMessage("No").that(actual).isEqualTo(result);
    } catch (RequestException e) {
      e.printStackTrace();
    }
  }

  @Test
  void executeWithoutSelector() {
    String[] header = {"name", "birthday_year", "comment"};
    String[][] body = {
            {"Slava", "1987", "ololo"},
            {"Gleb", "1985", "ololo2"},
            {"Serega", "1987", "ololo3"}};
    String[] columns = {"name", "comment"};
    String[][] result = {
            {"Slava", "ololo"},
            {"Gleb", "ololo2"},
            {"Serega", "ololo3"}};
    Selector selector = null;
    Csv csv = new Csv(header, body);
    var request = new SelectRequest.Builder().from(csv).where(selector).select(columns).build();
    try {
      var actual = request.execute();
      Truth.assertWithMessage("No").that(actual).isEqualTo(result);
    } catch (RequestException e) {
      e.printStackTrace();
    }
  }
  /*
  @Test
  void FindTable() {
    String[][] body = {
            {"Slava", "1987", "ololo"},
            {"Gleb", "1985", "ololo2"},
            {"Gleb", "1985", "ololo2"},
            {"Serg", "1987", "ololo3"},
            {"Serega", "1987", "ololo3"}};

    String[][] array = SelectRequest.FindTable(body, 1, "1987");
    System.out.println(Arrays.deepToString(array));
  }
  
   */
}