package week0.day4;

public class Numbers1 {

    public static int[] generateNumbers() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int findBiggest(int left, int right) {
        return left >= right ? left : right;
    }

    public static int findBiggest(int left, int mid, int right) {
        return findBiggest(findBiggest(left, mid), right);
    }

    public static int findBiggest(int[] numbers) {
        return numbers[findIndexOfBiggestNumber(numbers)];
    }

    public static int findIndexOfBiggestNumber(int[] numbers) {
        int max = numbers[0];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
                index = i;
            }
        }
        return index;
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static char[] convertToCharArray(int number) {
        boolean isNegativeNumber = isNegative(number);
        int length = getLengthNumber(number);

        if (isNegativeNumber) {
            number = -number;
            length++;
        }

        char[] chars = new char[length];

        do {
            int symbol = number % 10;
            chars[--length] = Character.forDigit(symbol, 10);
            number = number / 10;
        } while (number != 0);

        if (isNegativeNumber) {
            chars[0] = '-';
        }

        return chars;
    }

    protected static int getLengthNumber(int number) {
        int length = 0;
        do {
            number /= 10;
            length++;
        } while (number != 0);
        return length;
    }
}
