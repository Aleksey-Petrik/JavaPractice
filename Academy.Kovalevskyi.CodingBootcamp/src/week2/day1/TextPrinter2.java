package week2.day1;

public class TextPrinter2 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide 2 input argument, current amount: " + args.length);
            return;
        }

        StringBuilder sb = new StringBuilder();
        String text = args.length > 0 ? args[1] : "";
        int weight = text.length() + 2;

        String symbol = args[0];
        String line = symbol.repeat(weight);

        sb.append(String.format("%s%s%s%n", symbol, line, symbol))
                .append(String.format("%s %s %s%n", symbol, text, symbol))
                .append(String.format("%s%s%s", symbol, line, symbol));

        System.out.println(sb);
    }
}
