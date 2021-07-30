package week2.day2;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ProgressBar {
    public static void main(String[] args) throws InterruptedException {
        if (args.length < 2) {
            System.out.println("Please provide 2 or more input arguments, current amount: " + args.length);
            return;
        }

        int cntElem;
        int[] delaysIn = new int[args.length - 1];
        try {
            cntElem = checkValidity(Integer.parseInt(args[0]));
            for (int i = 1; i < args.length; i++) {
                delaysIn[i - 1] = checkValidity(Integer.parseInt(args[i]));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

        int[] delays = randomDelays(cntElem, delaysIn);
        int seconds = Arrays.stream(delays).sum();
        int percent = 0;
        int step = 100 / cntElem;
        int difference = 100 - step * cntElem;

        showProgressBar(percent, 0, 0, cntElem, seconds);
        for (int i = 0; i < cntElem; i++) {
            percent += difference-- > 0 ? step + 1 : step;
            seconds -= callDelay(delays[i]);
            showProgressBar(percent, percent - 1, i + 1, cntElem, seconds);
        }
        System.out.println("End!");
    }

    private static void showProgressBar(int percent, int lengthLoads, int elemI, int cntElem, int seconds) {
        System.out.printf("\r%3d%s[%-100s]  %3d/%3d, %s", percent, "% ", "=".repeat(lengthLoads) + ">", elemI, cntElem, timer(seconds));
    }

    private static int checkValidity(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    private static String timer(int seconds) {
        int hour = (seconds % 86400) / 3600;
        int min = ((seconds % 86400) % 3600) / 60;
        int sec = (((seconds % 86400) % 3600) % 60);
        return String.format("ETA: %02d:%02d:%02d", hour, min, sec);
    }

    private static int[] randomDelays(int cntElem, int[] delaysIn) {
        int[] delaysOut = new int[cntElem];
        for (int i = 0; i < cntElem; i++) {
            delaysOut[i] = delaysIn[(int) (Math.random() * delaysIn.length)];
        }
        return delaysOut;
    }

    private static int callDelay(int delay) throws InterruptedException {
        TimeUnit.SECONDS.sleep(delay);
        return delay;
    }
}
