package week2.day0;

import week0.day4.Numbers1;
import week1.day0.NumberUtils;

public class Numbers2 extends Numbers1 {

    public static char[][] generateTriplets() {
        int length = NumberUtils.factorialRecursive(10)
                / (NumberUtils.factorialRecursive(10 - 3)
                * NumberUtils.factorialRecursive(3));

        char[][] numbers = new char[length][3];
        int counter = 0;
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    if (i < j && j < k) {
                        numbers[counter][0] = Character.forDigit(i, 10);
                        numbers[counter][1] = Character.forDigit(j, 10);
                        numbers[counter][2] = Character.forDigit(k, 10);
                        counter++;
                    }
                }
            }
        }
        return numbers;
    }

    public static char[][] generateTuples() {
        char[][] numbers = new char[10_000][5];
        for (int i = 0; i < 10_000; i++) {
            char[] arr = convertToCharArray(i);
            int counter = arr.length;
            for (int j = numbers[i].length - 1; j >= 0; j--) {
                if (j == 2) {
                    numbers[i][j] = ' ';
                    continue;
                }
                if (counter > 0) {
                    numbers[i][j] = arr[--counter];
                } else {
                    numbers[i][j] = '0';
                }
            }
        }
        return numbers;
    }

    public static char[][] generateTuples(int amount) {
        if (isNegative(amount)) {
            throw new IllegalArgumentException();
        }
        if (amount == 0) {
            return new char[0][0];
        }
        int lengthChars = NumberUtils.powerRecursive(10, amount);
        char[][] numbers = new char[lengthChars][amount];
        for (int i = 0; i < lengthChars; i++) {
            char[] arr = convertToCharArray(i);
            int counter = arr.length;
            for (int j = numbers[i].length - 1; j >= 0; j--) {
                if (counter > 0) {
                    numbers[i][j] = arr[--counter];
                } else {
                    numbers[i][j] = '0';
                }
            }
        }
        return numbers;
    }
}
