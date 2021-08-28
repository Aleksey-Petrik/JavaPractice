package academy.kovalevskyi.algorithms.week2.day2;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntSetTest {
  private IntSet intSet = null;
  private int sum = 0;
  private final int count = 10_000;
  private final int bucketsCount = 5;

  @BeforeEach
  void setUp() {
    intSet = new IntSet(bucketsCount);
    for (int i = 0; i < count; i++) {
      intSet.add(i);
      sum += i;
    }
  }

  @Test
  void count() {
    Truth.assertWithMessage("ERROR").that(intSet.count()).isEqualTo(count);
    Truth.assertWithMessage("ERROR").that(intSet.countNodes()).isEqualTo(count);
  }

  @Test
  void sum() {
    Truth.assertWithMessage("ERROR").that(intSet.sum()).isEqualTo(sum);
    Truth.assertWithMessage("ERROR").that(intSet.sumNodes()).isEqualTo(sum);
  }

  @Test
  void contains() {
    Truth.assertWithMessage("ERROR").that(intSet.contains(69)).isEqualTo(true);
    Truth.assertWithMessage("ERROR").that(intSet.contains(9999)).isEqualTo(true);
    Truth.assertWithMessage("ERROR").that(intSet.contains(69)).isEqualTo(true);
    Truth.assertWithMessage("ERROR").that(intSet.contains(0)).isEqualTo(true);
    Truth.assertWithMessage("ERROR").that(intSet.contains(-6)).isEqualTo(false);
    Truth.assertWithMessage("ERROR").that(intSet.contains(10_001)).isEqualTo(false);
  }

  @Test
  void getBucketsCount() {
    Truth.assertWithMessage("ERROR").that(intSet.getBucketsCount()).isEqualTo(bucketsCount);
  }

}