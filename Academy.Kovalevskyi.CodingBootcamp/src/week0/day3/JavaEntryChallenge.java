package week0.day3;

public class JavaEntryChallenge {

    public static void main(String[] args) {

    }

    public static int sumOfTwoNumbers(int a, int b) {
        return a + b;
    }

    public static int convertMinToSec(int minutes) {
        return minutes * 60;
    }

    public static void compareTwoNumbers(int a, int b) {
        if (a > b) {
            System.out.print("Result: a is bigger");
        } else if (a < b) {
            System.out.print("Result: b is bigger");
        } else {
            System.out.print("Result: numbers are equal");
        }
    }

    public static void concatTwoStrings(String firstName, String lastName) {
        System.out.print(firstName + " " + lastName);
    }

    public static int remainder(int a, int b) {
        return a % b;
    }

    public static boolean divisibleBy5(int num) {
        return num % 5 == 0;
    }

    public static int firstElementOfArray(int[] arr) {
        return arr[0];
    }

    public static int smallestElementOfArray(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void checkResultOfWork(boolean quick, boolean efficient, boolean reliable) {
        if (quick == true && efficient == false && reliable == true) {
            System.out.print("Result of work: poor, but fast enough");
        } else if (quick == false && efficient == true && reliable == true) {
            System.out.print("Result of work: good, but tired of waiting");
        } else if (quick == true && efficient == true && reliable == false) {
            System.out.print("Result of work: excellent, but pricey");
        } else if (quick == true && efficient == true && reliable == true) {
            System.out.print("Result of work: excellent, but you are dreaming");
        } else {
            System.out.print("Pick at least two");
        }
    }

}
