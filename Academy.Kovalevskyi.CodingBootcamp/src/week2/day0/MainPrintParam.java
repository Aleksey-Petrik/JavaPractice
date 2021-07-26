package week2.day0;

public class MainPrintParam {
    public static void main(String[] args) {
        if (args.length != 0) {
            for (String arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("Please specify at least one argument!");
        }
    }
}
