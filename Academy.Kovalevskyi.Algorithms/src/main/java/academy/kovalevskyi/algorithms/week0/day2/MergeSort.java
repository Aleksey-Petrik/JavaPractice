package academy.kovalevskyi.algorithms.week0.day2;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSort implements Sort {

  public static void main(String[] args) {
    Integer[] array = {3, 6, 1, 7, 5, 4};
    MergeSort mergeSort = new MergeSort();
    System.out.println(Arrays.toString(mergeSort.createSortedArray(array, Integer::compareTo)));
  }

  @Override
  public <T> T[] createSortedArray(T[] target, Comparator<T> comparator) {
    T[] targetClone = target.clone();
    sort(targetClone, comparator);
    return targetClone;
  }

  @Override
  public <T> void sort(T[] target, Comparator<T> comparator) {
    T[] support = Arrays.copyOf(target, target.length);
    int n = target.length;
    for (int size = 1; size < n; size *= 2) {
      for (int j = 0; j < n - size; j += 2 * size) {
        merge(target, support, comparator, j, j + size - 1,
                j + size, Math.min(j + 2 * size - 1, n - 1));
      }
    }
  }

  private static <T> void merge(T[] array, T[] support, Comparator<T> comp,
                               int ls, int le, int rs, int re) {
    for (int i = ls; i <= re; i++) {
      support[i] = array[i];
    }
    int l = ls;
    int r = rs;
    for (int i = ls; i <= re; i++) {
      if (l > le) {
        array[i] = support[r];
        r++;
      } else if (r > re) {
        array[i] = support[l];
        l++;
      } else if (comp.compare(support[l], support[r]) < 0) {
        array[i] = support[l];
        l++;
      } else {
        array[i] = support[r];
        r++;
      }
    }
  }

  //сложность алгоритма в самом лучшем случае
  @Override
  public String complexityBest() {
    return "N*log(N)";
  }

  // сложность алгоритма в среднем
  @Override
  public String complexityAverage() {
    return "N*log(N)";
  }

  //сложность алгоритма в худшем случае
  @Override
  public String complexityWorst() {
    return "N";
  }

  //сложность алгоритма с точки зрения занимаемого места в памяти
  @Override
  public String spaceComplexityWorst() {
    return "N";
  }
}
