package week2.day3;

import java.util.Scanner;

public class TikTakToeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя первого игрока: ");
        Player firstPlayer = new Player(scanner.next(), 'X');

        System.out.print("\nВведите имя второго игрока: ");
        Player secondPlayer = new Player(scanner.next(), '0');

        TikTakToeGame game = new TikTakToeGame(firstPlayer, secondPlayer);

        String yesOrNo = "yes";
        do {
            if ("yes".equals(yesOrNo)) {
                game.startGame();
            }
            System.out.print("\n\nХотите начать игру заново? [yes/no]:");
        } while (!"no".equals(yesOrNo = scanner.next()));
    }
}
