package academy.kovalevskyi.javadeepdive.week0.day0;

import com.google.common.truth.Truth;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

class StdBufferedReaderTest {

  @Test
  void readLineNotNewLine() throws IOException {
    char[] expectedChars = "asdfasdfsafasdfsad asfasdfsadfsdafsda".toCharArray();
    char[] actualChars = new char[]{};
    Reader reader = new CharArrayReader(expectedChars);
    StdBufferedReader sbr2 = new StdBufferedReader(reader, 4);

    while (sbr2.hasNext()) {
      actualChars = sbr2.readLine();
    }

    Truth.assertWithMessage("").that(actualChars).isEqualTo(expectedChars);
  }

  @Test
  void readLineLongLines() throws IOException {
    Reader reader = new CharArrayReader(
            "sadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadf\nasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;\nsdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sd".toCharArray());
    List<char[]> expectedChars = new ArrayList<>();
    StdBufferedReader sbr2 = new StdBufferedReader(reader, 2);

    expectedChars.add("sadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadf".toCharArray());
    expectedChars.add("asdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;".toCharArray());
    expectedChars.add("sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sd".toCharArray());

    int counter = 0;
    while (sbr2.hasNext()) {
      Truth.assertWithMessage("").that(sbr2.readLine()).isEqualTo(expectedChars.get(counter++));
    }

    Truth.assertWithMessage("").that(counter).isEqualTo(3);
  }

  @Test
  void readLineSmallLines() throws IOException {
    Reader reader = new CharArrayReader("hello world\nhello hell hel\nhe".toCharArray());
    List<char[]> expectedChars = new ArrayList<>();
    StdBufferedReader sbr2 = new StdBufferedReader(reader, 2);

    expectedChars.add("hello world".toCharArray());
    expectedChars.add("hello hell hel".toCharArray());
    expectedChars.add("he".toCharArray());

    int counter = 0;
    while (sbr2.hasNext()) {
      Truth.assertWithMessage("").that(sbr2.readLine()).isEqualTo(expectedChars.get(counter++));
    }

    Truth.assertWithMessage("").that(counter).isEqualTo(3);
  }

  @Test
  void readLineFiveEmptyLines() throws IOException {
    Reader reader = new CharArrayReader("\n\n\n\n".toCharArray());
    StdBufferedReader sbr2 = new StdBufferedReader(reader);

    int counter = 0;
    while (sbr2.hasNext()) {
      Truth.assertWithMessage("Error").that(sbr2.readLine()).isEqualTo(new char[]{});
      counter++;
    }

    Truth.assertWithMessage("Error").that(counter).isEqualTo(4);
  }

  @Test
  void readLineNullException() {
    NullPointerException thrown = assertThrows(NullPointerException.class, () ->
      new StdBufferedReader(null), "Error");
    assertTrue(thrown.getMessage().contains("Reader is not be NULL!!!"));
  }

  @Test
  void readLineSmallBufferSize() {
    IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
            new StdBufferedReader(new CharArrayReader("bla bla".toCharArray()), -1 ), "Error");
    assertTrue(thrown.getMessage().contains("Buffer size is not be less 2!!!"));
  }

}