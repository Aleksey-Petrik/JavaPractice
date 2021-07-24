package week1.day0;

public class NumberUtils {

    private static void checkValidity(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("It should not be negative!");
        }
    }

    public static int getFactorial(final int number) {
        checkValidity(number);
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int factorialRecursive(int number) {
        checkValidity(number);
        return number < 2 ? 1 : number * factorialRecursive(--number);
    }

    public static long power(int base, int power) {
        checkValidity(power);
        int result = 1;
        for (int i = 0; i < power; i++) {
            result *= base;
        }
        return result;
    }

    public static int powerRecursive(int base, int power) {
        checkValidity(power);
        return power > 0 ? base * powerRecursive(base, --power) : 1;
    }

    public static int fibRecursive(int index) {
        checkValidity(index);
        return index <= 2 ? 1 : fibRecursive(index - 1) + fibRecursive(index - 2);
    }

    public static int[] fibSequence(int length) {
        checkValidity(length);
        int[] result = new int[length];
        while (length > 0) {
            result[length - 1] = fibRecursive(length--);
        }
        return result;
    }

    public static int sqrt(int target) {
        checkValidity(target);
        int val = target / 2;
        while (val > 1) {
            if (powerRecursive(val, 2) == target) {
                return val;
            }
            val--;
        }
        return -1;
    }

    public static boolean isPrime(int target) {
        checkValidity(target);
        int rez = target / 2;
        while (rez > 1) {
            if (target % rez-- == 0) {
                return false;
            }
        }
        return target > 1;
    }

    public static int findNextPrime(int target) {
        checkValidity(target);
        while (true) {
            if (isPrime(target)) {
                return target;
            }
            target++;
        }
    }

    public static void sort(int[] target) {
        if (target != null) {
            for (int j = 1; j < target.length; j++) {
                for (int i = 0; i < target.length - 1; i++) {
                    if (target[i] > target[i + 1]) {
                        int buf = target[i];
                        target[i] = target[i + 1];
                        target[i + 1] = buf;
                    }
                }
            }
        }
    }

}

