package academy.kovalevskyi.algorithms.week2.day2;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import org.junit.jupiter.api.Test;

class WikiScrapperTest {

  @Test
  void lastEditedOnDate() throws IOException, ParseException {
    var wikiScrapper = WikiScrapper.generateScrapper("https://en.wikipedia.org/w/index.php?title=Hash_table&oldid=1034399274");
    Date date = wikiScrapper.lastEditedOnDate();
  }

}