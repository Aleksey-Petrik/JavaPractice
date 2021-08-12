package academy.kovalevskyi.algorithms.week0.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InsertionSortTest {

  @Test
  void sortInteger() {
    InsertionSort is = new InsertionSort();
    Integer[] array = new Integer[]{5, 2, 1, 4, 3};
    is.sort(array, Integer::compare);
    Assertions.assertArrayEquals(array, new Integer[]{1, 2, 3, 4, 5}, "Array is not sorting.");
  }

  @Test
  void sortCharacter() {
    InsertionSort is = new InsertionSort();
    Character[] array = new Character[]{'D', 'B', 'A', 'C', 'E'};
    is.sort(array, Character::compare);
    Assertions.assertArrayEquals(array, new Character[]{'A', 'B', 'C', 'D', 'E'},
            "Array is not sorting.");
  }

}