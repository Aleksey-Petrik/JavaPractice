package week2.day0;

import week1.day1.Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MainPrintSortedParam {
    public static void main(String[] args) {
        if (args.length != 0) {
            Comparator<String> comparator = String::compareTo;

            Sorting.sort(args, comparator);//Ранее написанный метод в классе Sorting
            Arrays.stream(args).forEach(System.out::println);//Сортировка по возрастанию

            Sorting.sortReversedOrder(args, comparator);
            Arrays.stream(args).forEach(System.out::println);//Сортировка по убыванию

            Arrays.stream(args).sorted(String::compareTo).forEach(System.out::println);//В одной строке сортировка и вывод
        } else {
            System.out.println("Please specify at least one argument!");
        }
    }
}
