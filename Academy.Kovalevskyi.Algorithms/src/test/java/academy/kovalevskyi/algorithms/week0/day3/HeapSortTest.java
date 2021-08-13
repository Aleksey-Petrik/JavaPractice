package academy.kovalevskyi.algorithms.week0.day3;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeapSortTest {
  Sort sort = new Sort() {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] target) {
      Sort.super.sort(target);
    }

    @Override
    public Integer[] generateIntegerArray(int size) {
      return Sort.super.generateIntegerArray(size);
    }
  };

  @Test
  void sort() {
    for (int i = 0; i < 15; i++) {
      Integer[] array = sort.generateIntegerArray(10);
      Integer[] expected = array.clone();
      sort.sort(expected);
      System.out.println("Исх.  массив - " + Arrays.toString(array));
      HeapSort heapSort = new HeapSort();
      heapSort.sort(array, Integer::compareTo);
      Assertions.assertArrayEquals(expected, array);
      System.out.println("Сорт. массив - " + Arrays.toString(array) + "\n");
    }
  }
}