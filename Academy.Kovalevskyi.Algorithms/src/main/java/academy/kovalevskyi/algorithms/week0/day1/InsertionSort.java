package academy.kovalevskyi.algorithms.week0.day1;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import java.util.Comparator;

public class InsertionSort implements Sort {

  @Override
  public <T> void sort(T[] target, Comparator<T> comparator) {
    for (int i = 1; i < target.length; i++) {
      for (int j = i; j > 0 && comparator.compare(target[j - 1], target[j]) > 0; j--) {
        swap(target, j - 1, j);
      }
    }
  }

  //сложность алгоритма в самом лучшем случае
  @Override
  public String complexityBest() {
    return "N";
  }

  // сложность алгоритма в среднем
  @Override
  public String complexityAverage() {
    return "N^2";
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
