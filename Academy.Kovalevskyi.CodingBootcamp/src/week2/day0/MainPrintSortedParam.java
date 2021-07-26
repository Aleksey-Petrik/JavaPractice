package week2.day0;

public class MainPrintSortedParam {
    public static void main(String[] args) {
        if (args.length != 0) {
            for (int i = 1; i < args.length; i++) {
                for (int j = 0; j < args.length - 1; j++) {
                    if (args[j].compareTo(args[j + 1]) > 0) {
                        String buf = args[j];
                        args[j] = args[j + 1];
                        args[j + 1] = buf;
                    }
                }
            }
            for (String arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("Please specify at least one argument!");
        }
    }
}
