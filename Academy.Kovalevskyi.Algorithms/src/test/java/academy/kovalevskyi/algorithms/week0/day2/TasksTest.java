package academy.kovalevskyi.algorithms.week0.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TasksTest {
  private int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

  @Test
  void findIndex() {
    Assertions.assertEquals(4, Tasks.findIndex(array, 4).getAsInt());
    Assertions.assertEquals(7, Tasks.findIndex(array, 7).getAsInt());
    Assertions.assertEquals(11, Tasks.findIndex(array, 11).getAsInt());
    Assertions.assertEquals(0, Tasks.findIndex(array, 0).getAsInt());
  }

  @Test
  void noneIndex() {
    Assertions.assertEquals(0, Tasks.findIndex(array, 15).getAsInt());
  }
}