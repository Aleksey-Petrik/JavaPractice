package academy.kovalevskyi.javadeepdive.week0.day0;

import org.junit.jupiter.api.Test;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;

class StdBufferedReaderTest {

  @Test
  void readLine() throws IOException {
    //Reader reader = new CharArrayReader("asdfasdfsafasdfsad asfasdfsadfsdafsda".toCharArray());
    //Reader reader = new CharArrayReader(
    //        "sadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadf\nasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;\nsdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sdsadfasdfsadfh;asfhda;sd".toCharArray());
    Reader reader = new CharArrayReader("hello world\nhello hell hel\nhe".toCharArray());
   //Reader reader = new CharArrayReader("\n\n\n\n".toCharArray());
    StdBufferedReader sbr2 = new StdBufferedReader(reader, 4);

    while (sbr2.hasNext()) {
      System.out.println(sbr2.readLine());
    }

  }
}