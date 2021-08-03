package week2.day3;

public class Config {
    private static final int lengthDiagonal = 3;
    private static int sizeGameArea = lengthDiagonal * lengthDiagonal;

    public static int getSizeGameArea() {
        return sizeGameArea;
    }

    public static void setSizeGameArea(int sizeGameArea) {
        Config.sizeGameArea = sizeGameArea;
    }

    public static int getLengthDiagonal() {
        return lengthDiagonal;
    }
}
