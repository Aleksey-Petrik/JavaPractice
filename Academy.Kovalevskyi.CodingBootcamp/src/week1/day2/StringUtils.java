package week1.day2;

public class StringUtils {

    private static void checkValidity(char ch) {
        if (ch > 255) {
            throw new IllegalArgumentException("Not ASCI symbol!");
        }
    }

    private static void checkNull(Object chars) {
        if (chars == null) {
            throw new NullPointerException("Not NULL!");
        }
    }

    public static boolean isAsciiUppercase(char ch) {
        checkValidity(ch);
        return ch >= 'A' && ch <= 'Z';
    }

    public static boolean isAsciiLowercase(char ch) {
        checkValidity(ch);
        return ch >= 'a' && ch <= 'z';
    }

    public static boolean isAsciiNumeric(char ch) {
        checkValidity(ch);
        return ch >= '0' && ch <= '9';
    }

    public static boolean isAsciiAlphabetic(char ch) {
        return isAsciiLowercase(ch) || isAsciiUppercase(ch);
    }

    public static char toAsciiUppercase(char ch) {
        if (isAsciiLowercase(ch)) {
            ch -= 32;
        }
        return ch;
    }

    public static char toAsciiLowercase(char ch) {
        if (isAsciiUppercase(ch)) {
            ch += 32;
        }
        return ch;
    }

    public static StringBuilder makeUppercase(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            sb.append(toAsciiUppercase(ch));
        }
        return sb;
    }

    public static StringBuilder makeLowercase(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            sb.append(toAsciiLowercase(ch));
        }
        return sb;
    }

    public static StringBuilder makeCamel(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(i % 2 == 0 ? toAsciiLowercase(chars[i]) : toAsciiUppercase(chars[i]));
        }
        return sb;
    }

    public static boolean isStringAlphaNumerical(char[] chars) {
        for (char ch : chars) {
            if (!isAsciiAlphabetic(ch) && !isAsciiNumeric(ch) && ch != 32) {
                return false;
            }
        }
        return true;
    }

    public static char[] concatStrings(char[][] chars) {
        char[] newChars = new char[]{};
        if (chars.length > 0) {
            newChars = new char[chars.length * chars[0].length];
            int k = 0;
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < chars[i].length; j++) {
                    checkValidity(chars[i][j]);
                    newChars[k++] = chars[i][j];
                }
            }
        }
        return newChars;
    }

    public static int toInt(char[] chars) {
        int value = 0;
        boolean isNegative = false;
        if (chars.length > 0) {
            if (chars[0] == '-') {
                chars[0] = '0';
                isNegative = true;
            }
            for (char ch : chars) {
                checkValidity(ch);
                if (isAsciiNumeric(ch)) {
                    value = value * 10 + Character.digit(ch, 10);
                } else {
                    throw new NumberFormatException("Only int");
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        return isNegative ? -value : value;
    }
}
