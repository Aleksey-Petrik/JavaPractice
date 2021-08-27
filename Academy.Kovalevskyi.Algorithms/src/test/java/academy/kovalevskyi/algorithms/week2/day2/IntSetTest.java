package academy.kovalevskyi.algorithms.week2.day2;

import org.junit.jupiter.api.Test;

class IntSetTest {

  @Test
  void getBucketsCount() {
    IntSet intSet = new IntSet();
    int sum = 0;
    for (int i = 0; i < 10000; i++) {
      intSet.add(i);
      sum += i;
    }
    System.out.println(intSet.count());
    System.out.println(intSet.sum());
    System.out.println("SUM - " + sum);
  }

  @Test
  void sum() {

  }
}