package academy.kovalevskyi.algorithms.week0.day0;

import java.util.Comparator;

public interface Sort {
  default <T extends Comparable<? super T>> void sort(final T[] target) {
    sort(target, T::compareTo);
  }

  default <T> void sort(final T[] target, final Comparator<T> comparator) {
    boolean turn = true;
    while (turn) {
      turn = false;
      for (int i = 0; i < target.length - 1; i++) {
        if (comparator.compare(target[i], target[i + 1]) > 0) {
          T buff = target[i];
          target[i] = target[i + 1];
          target[i + 1] = buff;
          turn = true;
        }
      }
    }
  }

  default <T> T[] createSortedArray(final T[] target, final Comparator<T> comparator) {
    T[] targetClone = target.clone();
    sort(targetClone, comparator);
    return targetClone;
  }

  default <T> void swap(T[] target, int currentIndex, int swapIndex) {
    T buf = target[currentIndex];
    target[currentIndex] = target[swapIndex];
    target[swapIndex] = buf;
  }

  default Integer[] generateIntegerArray(int size) {
    Integer[] array = new Integer[size];
    for (int i = 0; i < size; i++) {
      array[i] = (int) (Math.random() * 20);
    }
    return array;
  }

  //сложность алгоритма в самом лучшем случае
  default String complexityBest() {
    return "N";
  }

  // сложность алгоритма в среднем
  default String complexityAverage() {
    return "N^2";
  }

  //сложность алгоритма в худшем случае
  default String complexityWorst() {
    return "N^2";
  }

  //сложность алгоритма с точки зрения занимаемого места в памяти
  default String spaceComplexityWorst() {
    return "N";
  }

}
