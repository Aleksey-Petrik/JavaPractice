package week2.day1;

public class TextPrinter {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide only one input argument, current amount: " + args.length);
            return;
        }

        StringBuilder sb = new StringBuilder();

        String text = args.length > 0 ? args[0] : "";
        int weight = text.length() + 2;

        String line = "#".repeat(weight);
        sb.append(String.format("/%s\\%n", line))
                .append(String.format("# %s #%n", text))
                .append(String.format("\\%s/", line));

        System.out.println(sb);
    }
}
