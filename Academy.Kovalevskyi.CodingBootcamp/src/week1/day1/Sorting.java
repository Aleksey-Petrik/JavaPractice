package week1.day1;

import java.util.Comparator;

public class Sorting {

    public static <T> void sort(T[] target, Comparator<T> comparator) {
        checkValidity(target, comparator);
        for (int j = 1; j < target.length; j++) {
            for (int i = 0; i < target.length - 1; i++) {
                if (comparator.compare(target[i], target[i + 1]) > 0) {
                    T buf = target[i];
                    target[i] = target[i + 1];
                    target[i + 1] = buf;
                }
            }
        }
    }

    public static <T> void sortReversedOrder(T[] target, Comparator<T> comparator) {
        checkValidity(target, comparator);
        sort(target, comparator.reversed());
    }

    private static <T> void checkValidity(T[] target, Comparator<T> comparator) {
        if (target == null || comparator == null) {
            throw new NullPointerException("Not NULL comparator and array!!!");
        }
    }

}
