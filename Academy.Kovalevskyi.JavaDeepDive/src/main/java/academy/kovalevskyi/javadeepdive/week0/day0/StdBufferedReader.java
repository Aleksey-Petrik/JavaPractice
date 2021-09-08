package academy.kovalevskyi.javadeepdive.week0.day0;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;

public class StdBufferedReader implements Closeable {
  private static final int MIN_BUFFER_SIZE = 2;
  private final Reader reader;
  private final int bufferSize;
  private char[] buffer;
  private int charCount = 0;
  private int bufferCursor = 0;

  public StdBufferedReader(Reader reader, int bufferSize) {
    if (reader == null) {
      throw new NullPointerException("Reader is not be NULL!!!");
    }
    if (bufferSize < MIN_BUFFER_SIZE) {
      throw new IllegalArgumentException("Buffer size is not be less 2!!!");
    }
    this.reader = reader;
    this.bufferSize = bufferSize;
    buffer = new char[bufferSize];
  }

  public StdBufferedReader(Reader reader) {
    this(reader, MIN_BUFFER_SIZE);
  }

  public boolean hasNext() throws IOException {
    return reader.ready() || bufferCursor < charCount;
  }

  public char[] readLine() throws IOException {
    char[] bufChars = new char[]{};
    char[] bufChars2 = new char[]{};

    boolean turn = true;
    while (turn && hasNext()) {

      if (bufferCursor >= charCount) {
        fill();
      }

      int i;
      int startPosition = bufferCursor;
      for (i = startPosition; i < charCount; i++) {
        if (buffer[i] == '\n') {
          turn = false;
          break;
        }
      }

      if (bufferCursor == i) {
        bufferCursor++;
        return bufChars.length == 0 ? bufChars2 : bufChars;
      }
      bufferCursor = i;

      if (bufChars.length == 0) {
        if (bufChars2.length != 0) {
          bufChars = swapArrays(buffer, bufChars2, bufferCursor, 0);
        } else {
          bufChars = swapArrays(buffer, bufChars, bufferCursor - startPosition, startPosition);
        }
        bufChars2 = new char[]{};
      } else {
        bufChars2 = swapArrays(buffer, bufChars, bufferCursor, 0);
        bufChars = new char[]{};
      }
    }
    bufferCursor++;
    return bufChars.length == 0 ? bufChars2 : bufChars;
  }

  public void close() throws IOException {
    if (reader == null) {
      return;
    }
    reader.close();
  }

  private char[] swapArrays(char[] buffer, char[] chars2, int lengthInsert, int positionInsert) {
    char[] chars = new char[chars2.length + lengthInsert];
    System.arraycopy(chars2, 0, chars, 0, chars2.length);
    System.arraycopy(buffer, positionInsert, chars, chars2.length, lengthInsert);
    return chars;
  }

  private void fill() throws IOException {
    charCount = reader.read(buffer, 0, bufferSize);
    bufferCursor = 0;

    if (!reader.ready() && buffer[charCount - 1] == '\n') {
      if (buffer.length > charCount) {
        buffer[charCount] = '\n';
        charCount++;
      }
    }
  }
}