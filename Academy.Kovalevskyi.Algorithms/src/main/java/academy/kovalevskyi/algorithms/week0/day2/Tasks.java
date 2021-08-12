package academy.kovalevskyi.algorithms.week0.day2;

import java.util.OptionalInt;

public class Tasks {

  public static void main(String[] args) {
    OptionalInt index = findIndex(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 4);
    System.out.println(index.getAsInt());
  }

  public static OptionalInt findIndex(int[] sortedArray, int target) {
    OptionalInt index;
    int left = 0;
    int right = sortedArray.length - 1;
    while (left <= right) {
      index = OptionalInt.of((right + left) / 2);
      if (sortedArray[index.getAsInt()] == target) {
        return index;
      } else if (sortedArray[index.getAsInt()] > target) {
        right = index.getAsInt() - 1;
      } else {
        left = index.getAsInt() + 1;
      }
    }
    return OptionalInt.of(0);
  }
}