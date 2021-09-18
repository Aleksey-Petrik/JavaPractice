package academy.kovalevskyi.javadeepdive.week2.day0;

import java.util.Objects;

public class SimpleStringIntegerClass {

  private final String one;
  private final String two;
  private final int oneInt;
  private final int twoInt;

  public SimpleStringIntegerClass() {
    this("", "", 0, 0);
  }

  public SimpleStringIntegerClass(String one, String two, int oneInt, int twoInt) {
    this.one = one;
    this.two = two;
    this.oneInt = oneInt;
    this.twoInt = twoInt;
  }

  public String getOne() {
    return one;
  }

  public String getTwo() {
    return two;
  }

  public int getOneInt() {
    return oneInt;
  }

  public int getTwoInt() {
    return twoInt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SimpleStringIntegerClass that = (SimpleStringIntegerClass) o;
    return oneInt == that.oneInt && twoInt == that.twoInt && Objects.equals(one, that.one) && Objects.equals(two, that.two);
  }

  @Override
  public int hashCode() {
    return Objects.hash(one, two, oneInt, twoInt);
  }
}
