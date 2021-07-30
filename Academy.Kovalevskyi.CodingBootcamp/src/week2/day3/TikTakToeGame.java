package week2.day3;

import java.util.Scanner;

public class TikTakToeGame {
    private Player firstPlayer;
    private Player secondPlayer;

    private int maxCountGameStep = 9;
    private boolean findWin = false;

    private char[] gameArea = null;

    public TikTakToeGame(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    private void initNewGame() {
        createGameArea();

        firstPlayer.setWin(false);
        secondPlayer.setWin(false);

        maxCountGameStep = 9;
        findWin = false;
    }

    private void createGameArea() {
        gameArea = new char[]{
                '*', '*', '*',
                '*', '*', '*',
                '*', '*', '*'
        };
    }

    public void startGame() {
        initNewGame();

        System.out.print("\n     Игра началась!!!\n");
        printGameArea();

        Player currentPlayer = firstPlayer;
        while (!findWin && maxCountGameStep > 0) {
            System.out.println("\nДо конца игры осталось: " + maxCountGameStep-- + " игровых ходов");
            System.out.print("\nХод делает игрок с именем \""
                    + currentPlayer.getName()
                    + "\" ("
                    + currentPlayer.getSymbol() + ") - ");

            gameArea[enterNumber(currentPlayer)] = currentPlayer.getSymbol();
            printGameArea();

            findWin = checkWin();
            if (findWin) {
                currentPlayer.setWin(true);
            } else {
                currentPlayer = currentPlayer == firstPlayer ? secondPlayer : firstPlayer;
            }
        }

        if (currentPlayer.isWin()) {
            System.out.print("\nПобедил игрок под именем - \""
                    + currentPlayer.getName()
                    + "\"!!! Количество побед - "
                    + currentPlayer.getCntWins() + "\n");
        } else {
            System.out.print("Игра окончилась ничьей!!!");
        }
    }

    private boolean checkWin() {
        for (int i = 0; i < 9; i += 3) {
            if (gameArea[i] != '*') {
                if (gameArea[i] == gameArea[i + 1] &&
                        gameArea[i + 1] == gameArea[i + 2]) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (gameArea[i] != '*') {
                if (gameArea[i] == gameArea[i + 3] &&
                        gameArea[i + 3] == gameArea[i + 6]) {
                    return true;
                }
            }
        }
        if (gameArea[4] != '*') {
            return gameArea[0] == gameArea[4] && gameArea[4] == gameArea[8] ||
                    gameArea[2] == gameArea[4] && gameArea[4] == gameArea[6];
        }
        return false;
    }

    //Печать игрового поля
    public void printGameArea() {
        System.out.println();
        for (int i = 0; i < 9; i += 3) {
            System.out.printf("\t%s | %s | %s %n", gameArea[i],
                    gameArea[i + 1], gameArea[i + 2]);
        }
    }

    //Ход игрока + проверка на заполненность ячейки
    private int enterNumber(Player player) {
        Scanner scanner = new Scanner(System.in);
        int cell;
        do {
            cell = scanner.nextInt();
            if (gameArea[cell] != '*') {
                System.out.println("Игрок - " + player.getName() + " ячейка " + cell + " занята, выбери другую!");
                System.out.print("Давай игрок " + player.getName() + " вводи: ");
            } else {
                return cell;
            }
        } while (true);
    }
}