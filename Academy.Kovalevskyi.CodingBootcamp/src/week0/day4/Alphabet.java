package week0.day4;

public class Alphabet {
    private static final int SIZE = 26;

    public static char[] generateAlphabet() {
        char[] alphabet = new char[SIZE];
        for (int i = 0; i < SIZE; i++) {
            alphabet[i] = (char) ('a' + i);
        }
        return alphabet;
    }

    public static char[] generateReversedAlphabet() {
        char[] alphabetReverse = new char[SIZE];
        char[] alphabet = generateAlphabet();
        for (int i = 0; i < SIZE; i++) {
            alphabetReverse[i] = alphabet[SIZE - (i + 1)];
        }
        return alphabetReverse;
    }
}
