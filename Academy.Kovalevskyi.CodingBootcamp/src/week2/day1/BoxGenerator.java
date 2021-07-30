package week2.day1;

import week0.day4.Numbers1;

public class BoxGenerator {
    public static void main(String[] args) {
        int length;
        int weight;

        if (args.length != 4) {
            System.out.println("Please provide 4 input arguments, current amount: " + args.length);
            return;
        }
        try {
            weight = Integer.parseInt(args[1]);
            length = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (Numbers1.isNegative(weight) || Numbers1.isNegative(length)
                || args[2].length() > 1 || args[3].length() > 1) {
            throw new IllegalArgumentException();
        }

        char line = args[2].charAt(0);
        char angle = args[3].charAt(0);

        weight = printLine(length, weight, angle, line);
        weight = printVer(length, weight, line, ' ');
        printLine(length, weight, angle, line);
    }

    private static int printVer(int length, int weight, char angle, char line) {
        for (int i = 0; i < weight; i++) {
            weight = printLine(length, weight, angle, line);
        }
        return weight;
    }

    private static int printLine(int length, int weight, char angle, char line) {
        if (weight == 0 || length == 0) {
            return 0;
        }
        for (int i = 0; i < length; i++) {
            if (i == 0 || i == length - 1) {
                System.out.print(angle);
            } else {
                System.out.print(line);
            }
        }
        System.out.println();
        return --weight;
    }

}
