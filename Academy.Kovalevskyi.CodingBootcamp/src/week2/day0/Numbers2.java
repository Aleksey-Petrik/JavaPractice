package week2.day0;

import week0.day4.Numbers1;
import week1.day0.NumberUtils;

import java.util.Arrays;

public class Numbers2 extends Numbers1 {

    public static void main(String[] args) {
        char[][]arr = generateTuples(5);

        for (char[] chars : arr) {
            System.out.println(Arrays.toString(chars));
        }

    }

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
    for(int i = 0; i < numbers.length; i++){
        numbers[i][2] = ' ';
    }
    return getGenerateTuples(numbers);
}

public static char[][] generateTuples(int amount) {
    if (isNegative(amount)) {
        throw new IllegalArgumentException();
    }
    if (amount == 0) {
        return new char[0][0];
    }
    char[][] numbers = new char[NumberUtils.powerRecursive(10, amount)][amount];
    return getGenerateTuples(numbers);
}

private static char[][] getGenerateTuples(char[][] array) {
    for (int i = 0; i < array.length; i++) {
        char[] arr = convertToCharArray(i);
        int counter = arr.length;
        for (int j = array[i].length - 1; j >= 0; j--) {
            if (array[i][j] == ' ') {
                continue;
            }
            array[i][j] = counter > 0 ? arr[--counter] : '0';
        }
    }
    return array;
}
}
