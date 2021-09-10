package academy.kovalevskyi.javadeepdive.week0.day2;

import java.util.Arrays;

public record Csv(String[] header, String[][] values) {

  public static class Builder {

    private String[] header;
    private String[][] values;

    public Builder header(String[] header) {
      this.header = header;
      return this;
    }

    public Builder values(String[][] values) {
      this.values = values;
      return this;
    }

    public Csv build() {
      return new Csv(header, values);
    }
  }

  public boolean withHeader() {
    return header != null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Csv csv = (Csv) o;
    return Arrays.equals(header(), csv.header())
            && Arrays.deepEquals(header(), csv.header());
  }

  @Override
  public int hashCode() {
    return 29 * Arrays.hashCode(header) + Arrays.deepHashCode(values);
  }
}