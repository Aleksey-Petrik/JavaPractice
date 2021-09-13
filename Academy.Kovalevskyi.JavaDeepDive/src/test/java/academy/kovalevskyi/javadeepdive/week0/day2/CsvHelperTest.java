package academy.kovalevskyi.javadeepdive.week0.day2;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;

class CsvHelperTest {
  private Csv csv;
  private Csv csv2;

  @BeforeEach
  void setUp() throws IOException {

    String strLine = "\"Slava, Kovalevski\",1987,ololo\nGleb,1985,ololo2\nSerega,1987,'ololo3, test'";
    Reader reader = new CharArrayReader(strLine.toCharArray());
    csv = CsvHelper.parseFile(reader, false, ',');

    String strLine2 = "name,year,note\n\"Slava, Kovalevski\",1987,ololo\nGleb,1985,ololo2\nSerega,1987,'ololo3, test'";
    Reader reader2 = new CharArrayReader(strLine2.toCharArray());
    csv2 = CsvHelper.parseFile(reader2, true, ',');

  }

  @Test
  void parseFileTestQuotes1() throws IOException {

    String testStr = """
            "Slava,1987",ololo
            "Gleb,1985",ololo2
            "Serega,1987",ololo3
            """;

    Reader reader = new CharArrayReader(testStr.toCharArray());
    Csv csv = CsvHelper.parseFile(reader, false, ',');

    Truth.assertWithMessage("Error").that(csv.values()[0][0]).isEqualTo("Slava,1987");
  }

  @Test
  void parseFileTestQuotes2() throws IOException {

    String testStr = """
            "Slava,1987,ololo"
            "Gleb,1985,ololo2"
            "Serega,1987,ololo3"
            """;

    Reader reader = new CharArrayReader(testStr.toCharArray());
    Csv csv = CsvHelper.parseFile(reader, false, ',');

    Truth.assertWithMessage("Error").that(csv.values()[0][0]).isEqualTo("Slava,1987,ololo");
  }

  @Test
  void parseFileTestQuotes3() throws IOException {

    String testStr = """
            "Slava,1987,ololo","Gleb,1985,ololo2"
            "Gleb,1985,ololo2","123,45645"
            "Serega,1987,ololo3","Alex,Petrov"
            """;

    Reader reader = new CharArrayReader(testStr.toCharArray());
    Csv csv = CsvHelper.parseFile(reader, false, ',');

    Truth.assertWithMessage("Error").that(csv.values()[2][1]).isEqualTo("Alex,Petrov");
  }

  @Test
  void parseFileNullHeader() {
    Truth.assertWithMessage("Error").that(csv.header()).isEqualTo(null);
  }

  @Test
  void parseFileNotNullHeader() {
    Truth.assertWithMessage("Error").that(csv2.header()).isEqualTo(new String[]{"name", "year", "note"});
  }

  @Test
  void parseFileCountValue() {
    Truth.assertWithMessage("Error").that(csv.values().length).isEqualTo(3);
  }

  @Test
  void parseFileEqualValues() {

    Truth.assertWithMessage("Error").that(csv.values()).isEqualTo(new String[][]{
            {"Slava, Kovalevski", "1987", "ololo"},
            {"Gleb", "1985", "ololo2"},
            {"Serega", "1987", "'ololo3, test'"}
    });

    Truth.assertWithMessage("Error").that(csv2.values()).isEqualTo(new String[][]{
            {"Slava, Kovalevski", "1987", "ololo"},
            {"Gleb", "1985", "ololo2"},
            {"Serega", "1987", "'ololo3, test'"}
    });
  }
}