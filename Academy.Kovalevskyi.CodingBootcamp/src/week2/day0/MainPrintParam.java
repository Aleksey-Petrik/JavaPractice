package week2.day0;

import java.util.Arrays;

public class MainPrintParam {
    public static void main(String[] args) {
        if (args.length != 0) {
            Arrays.stream(args).forEach(System.out::println);
        } else {
            System.out.println("Please specify at least one argument!");
        }
    }
}
