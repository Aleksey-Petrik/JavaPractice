import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChessMain {
    private static final int COUNT_COLUMNS = 8;
    private static String[][] playingField = new String[8][8];
    private static char[] simbolsArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

    public String[][] getPlayingField() {
        return playingField;
    }

    public void printPlayingField() {
        for (int i = playingField.length - 1; i >= 0; i--) {
            System.out.print("[" + (i + 1) + "]");
            for (int j = playingField[i].length - 1; j >= 0; j--) {
                System.out.print(playingField[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("   ");
        for(int i = 0; i < simbolsArray.length; i++) {
            System.out.print("[" + simbolsArray[i] + "]  ");
        }
    }

    public void createPlayingField() {
        for (int i = 0; i < playingField.length; i++) {
            Arrays.fill(playingField[i], "[  ]");
        }
    }

    public static void main(String[] args) {
        ArrayList<Player> playersList = new ArrayList<>();
        ChessMain chessGame = new ChessMain();

        try {
            playersList = chessGame.createPlayers();
        } catch (IllegalArgumentException err) {
            System.out.println(err.getMessage());
        }

        chessGame.createPlayingField();
        try {
            for (Player player : playersList) {
                System.out.println(player.toString());
                chessGame.createPieces(player);
            }
        } catch (NullPointerException err) {
            System.out.println("Объекты не созданы из-за ошибки!");
        }
        chessGame.printPlayingField();
    }

    public ArrayList<Player> createPlayers() throws IllegalArgumentException {
        ArrayList<Player> playersList = new ArrayList<>();

        playersList.add(new Player("White", "white@gmail.com", 25));
        playersList.add(new Player("Black", "Black@gmail.com", 40));

        playersList.get(0).setRank(2000);
        playersList.get(1).setRank(2500);

        playersList.get(0).setWhite(true);

        return playersList;
    }

    public void createPieces(Player player) {
        int whiteRow = 1;
        int blackRow = 6;
        int column = 0;
        ArrayList<AbstractPiece> piecesBottom = new ArrayList<>();
        ArrayList<AbstractPiece> piecesTop = new ArrayList<>();
        for (column = 0; column < COUNT_COLUMNS; column++) {
            int posY = whiteRow;
            if (!player.isWhite()) {
                posY = blackRow;
            }
            piecesBottom.add(new Pawn(column, player.isWhite(), false, new Spot(simbolsArray[column], posY)));
            playingField[posY][column] = player.isWhite() ? "[wP]" : "[bP]";
        }

        int posY = whiteRow;
        if (!player.isWhite()) {
            posY = blackRow;
        }
        column = 0;
        piecesTop.add(new Bishop(column, player.isWhite(), false, new Spot(simbolsArray[column], posY)));
        column++;
        piecesTop.add(new Horse(column, player.isWhite(), false, new Spot(simbolsArray[column], posY)));
        column++;
        piecesTop.add(new Rook(column, player.isWhite(), false, new Spot(simbolsArray[column], posY)));
        column++;
        piecesTop.add(new Queen(column, player.isWhite(), false, new Spot(simbolsArray[column], posY)));
        column++;
        piecesTop.add(new King(column, player.isWhite(), false, new Spot(simbolsArray[column], posY)));
        column++;
        piecesTop.add(new Rook(column, player.isWhite(), false, new Spot(simbolsArray[column], posY)));
        column++;
        piecesTop.add(new Horse(column, player.isWhite(), false, new Spot(simbolsArray[column], posY)));
        column++;
        piecesTop.add(new Bishop(column, player.isWhite(), false, new Spot(simbolsArray[column], posY)));



        King king = new King(0, true, false, new Spot('D', 1));
        System.out.println(king.toString());
    }
}
