package academy.kovalevskyi.javadeepdive.week0.day2;

import academy.kovalevskyi.javadeepdive.week0.day0.StdBufferedReader;

import java.io.*;
import java.util.ArrayList;
import java.util.function.Predicate;

public class CsvHelper {

  // deserialize
  public static Csv parseFile(Reader reader) throws IOException {
    return parseFile(reader, false, ',');
  }

  // deserialize
  public static Csv parseFile(Reader reader, boolean withHeader, char delimiter) throws IOException {
    String[] header = null;
    var valueList = new ArrayList<String[]>();
    try (StdBufferedReader sbr = new StdBufferedReader(reader)) {
      while (sbr.hasNext()) {
        String[] strLine = parseLine(sbr.readLine(), delimiter);
        if (withHeader && header == null) {
          header = strLine;
        } else {
          valueList.add(strLine);
        }
      }
    }
    return new Csv.Builder().header(header).values(valueList.toArray(String[][]::new)).build();
  }

  // serialize
  public static void writeCsv(Writer writer, Csv csv, char delimiter) throws IOException {
    try (writer) {
      if (csv.withHeader()) {
        writer.write(wordsToLine(csv.header(), String.valueOf(delimiter)));
      }
      for (String[] words : csv.values()) {
        writer.write(wordsToLine(words, String.valueOf(delimiter)));
      }
    }
  }

  private static String wordsToLine(String[] words, String delimiter) {
    return String.join(delimiter, words) + "\n";
  }

  private static final Predicate<Character> isQuotationMark = symbol -> symbol == '\"' || symbol == '\'';

  private static String[] parseLine(char[] chars, char delimiter) {
    char quotationMark = '\u0000';
    for (int i = 0; i < chars.length; i++) {
      if (isQuotationMark.test(chars[i])) {
        quotationMark = isQuotationMark.test(quotationMark) ? '\u0000' : chars[i];
      }
      if (chars[i] == delimiter && !isQuotationMark.test(quotationMark)) {
        chars[i] = '\n';
      }
    }
    return new String(chars).split("\n");
  }
}