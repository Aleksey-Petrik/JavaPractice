package academy.kovalevskyi.algorithms.week0.day0;

import java.util.Arrays;

public class Tasks {

  public static boolean sameCharactersSorting(String left, String right) {
    Integer[] leftArray = left.chars().boxed().toArray(Integer[]::new);
    Integer[] rightArray = right.chars().boxed().toArray(Integer[]::new);

    Sort sort = new Sort() {
      @Override
      public <T extends Comparable<? super T>> void sort(T[] target) {
        Sort.super.sort(target);
      }
    };

    sort.sort(leftArray);
    sort.sort(rightArray);

    return Arrays.equals(leftArray, rightArray);
  }

  public static boolean sameCharactersO1(String left, String right) {
    if (left.length() != right.length()) {
      return false;
    }

    int[] mass = new int[255];
    char[] leftArray = left.toCharArray();
    char[] rightArray = right.toCharArray();

    for (int i = 0; i < left.length(); i++) {
      mass[leftArray[i]]++;
      mass[rightArray[i]]--;
    }

    for (char ch : leftArray) {
      if (mass[ch] != 0) {
        return false;
      }
    }
    return true;
  }

}
