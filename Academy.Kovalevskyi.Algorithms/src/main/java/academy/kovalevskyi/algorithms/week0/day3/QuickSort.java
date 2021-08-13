package academy.kovalevskyi.algorithms.week0.day3;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import java.util.Comparator;

public class QuickSort implements Sort {

  @Override
  public <T> void sort(T[] target, Comparator<T> comparator) {
    quickSortMethod(target, 0, target.length - 1, comparator);
  }

  private <T> void quickSortMethod(T[] array, int lo, int hi, Comparator<T> comparator) {
    if (lo >= hi) {
      return;
    }
    int h = breakPartition(array, lo, hi, comparator);
    quickSortMethod(array, lo, h - 1, comparator);
    quickSortMethod(array, h + 1, hi, comparator);
  }

  private <T> int breakPartition(T[] array, int lo, int hi, Comparator<T> comparator) {
    int i = lo + 1;
    int j = hi;
    T supportElement = array[lo];
    while (true) {
      for (; i < hi && comparator.compare(array[i], supportElement) < 0; i++) {
      }
      for (; comparator.compare(array[j], supportElement) > 0; j--) {
      }
      if (i >= j) {
        break;
      }
      swap(array, i++, j--);
    }
    swap(array, lo, j);
    return j;
  }

  //сложность алгоритма в самом лучшем случае
  @Override
  public String complexityBest() {
    return "N";
  }

  // сложность алгоритма в среднем
  @Override
  public String complexityAverage() {
    return "N*log(N)";
  }

  //сложность алгоритма в худшем случае
  @Override
  public String complexityWorst() {
    return "N^2";
  }

  //сложность алгоритма с точки зрения занимаемого места в памяти
  @Override
  public String spaceComplexityWorst() {
    return "N";
  }

}
