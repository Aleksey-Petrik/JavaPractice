package academy.kovalevskyi.algorithms.week0.day3;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import java.util.Comparator;

public class HeapSort implements Sort {

  @Override
  public <T> void sort(T[] target, Comparator<T> comparator) {
    int length = target.length;

    // Построение кучи (перегруппируем массив)
    for (int i = length / 2 - 1; i >= 0; i--) {
      heap(target, comparator, length, i);
    }
    // Один за другим извлекаем элементы из кучи
    for (int i = length - 1; i >= 0; i--) {
      // Перемещаем текущий корень в конец
      swap(target, 0, i);
      // Вызываем процедуру heapify на уменьшенной куче
      heap(target, comparator, i, 0);
    }
  }

  private <T> void heap(T[] target, Comparator<T> comparator, int n, int i) {
    int largest = i; // Инициализируем наибольший элемент как корень
    int l = 2 * i + 1; // левый = 2*i + 1
    int r = 2 * i + 2; // правый = 2*i + 2

    // Если левый дочерний элемент больше корня
    if (l < n && comparator.compare(target[l], target[largest]) > 0) {
      largest = l;
    }
    // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
    if (r < n && comparator.compare(target[r], target[largest]) > 0) {
      largest = r;
    }
    // Если самый большой элемент не корень
    if (largest != i) {
      swap(target, i, largest);
      // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
      heap(target, comparator, n, largest);
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
    return "N*log(N)";
  }

  //сложность алгоритма с точки зрения занимаемого места в памяти
  @Override
  public String spaceComplexityWorst() {
    return "N";
  }

}
