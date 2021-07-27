package week2.day0;

public class Calculator {
    public static void main(String[] args) {
        long a;
        long b;
        if (args.length == 3) {
            try {
                a = Long.parseLong(args[0]);
                b = Long.parseLong(args[2]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
            if (b == 0 && ("/".equals(args[1]) || "%".equals(args[1]))) {
                System.out.println("Division by zero is impossible!");
                return;
            }
            long result;
            switch (args[1]) {
                case "+" -> result = a + b;
                case "-" -> result = a - b;
                case "/" -> result = a / b;
                case "*" -> result = a * b;
                case "%" -> result = a % b;
                default -> throw new IllegalArgumentException();
            }
            System.out.println("result: " + result);
        } else {
            System.out.println("Please provide 3 input arguments, example: 2 + 3");
        }
    }
}
