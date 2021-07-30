package week2.day3;

public class Player {
    private final String name;
    private final char symbol;
    private boolean isWin = false;
    private int cntWins = 0;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public int getCntWins() {
        return cntWins;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean isWin) {
        if (isWin) {
            cntWins++;
        }
        this.isWin = isWin;
    }
}
