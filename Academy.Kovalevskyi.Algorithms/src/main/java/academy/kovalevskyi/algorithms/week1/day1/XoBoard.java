
package academy.kovalevskyi.algorithms.week1.day1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class XoBoard {
  private XoFigure[][] gameBoard;

  public static void main(String[] args) {
    XoBoard xoBoard = new XoBoard();
    xoBoard.setFigure(0, 0, XoFigure.figureX);
    xoBoard.setFigure(0, 1, XoFigure.figureO);
    xoBoard.setFigure(0, 2, XoFigure.figureX);

    for (int i = 0; i < xoBoard.gameBoard.length; i++) {
      for (int j = 0; j < xoBoard.gameBoard[i].length; j++) {
        int has = xoBoard.gameBoard[i][j].hashCode();

      }
    }

  }

  public XoBoard() {
    gameBoard = new XoFigure[3][3];
  }

  public XoBoard(XoBoard copy) {
    this();
    for (int i = 0; i < gameBoard.length; i++) {
      gameBoard[i] = Arrays.copyOf(copy.gameBoard[i], copy.gameBoard[i].length);
    }
  }

  public XoBoard(XoFigure[][] board) {
    this.gameBoard = board;
  }

  public XoFigure getFigure(int x, int y) {
    return gameBoard[x][y];
  }

  public void setFigure(int x, int y, XoFigure figure) {
    if (gameBoard[x][y] == null) {
      gameBoard[x][y] = figure;
    }
  }

  public XoFigure hasWinner() {
    // 1st diagonal
    if (gameBoard[0][0] != null && gameBoard[0][0].equals(gameBoard[1][1])
            && gameBoard[0][0].equals(gameBoard[2][2])) {
      return gameBoard[0][0];
    }
    //2st diagonal
    if (gameBoard[0][2] != null && gameBoard[0][2].equals(gameBoard[1][1])
            && gameBoard[0][2].equals(gameBoard[2][0])) {
      return gameBoard[0][2];
    }
    //1st column
    if (gameBoard[0][0] != null && gameBoard[0][0].equals(gameBoard[1][0])
            && gameBoard[0][0].equals(gameBoard[2][0])) {
      return gameBoard[0][0];
    }
    // 2st column
    if (gameBoard[0][1] != null && gameBoard[0][1].equals(gameBoard[1][1])
            && gameBoard[0][1].equals(gameBoard[2][1])) {
      return gameBoard[0][1];
    }
    //3d column
    if (gameBoard[0][2] != null && gameBoard[0][2].equals(gameBoard[1][2])
            && gameBoard[0][2].equals(gameBoard[2][2])) {
      return gameBoard[0][2];
    }
    // 1st row
    if (gameBoard[0][0] != null && gameBoard[0][0].equals(gameBoard[0][1])
            && gameBoard[0][0].equals(gameBoard[0][2])) {
      return gameBoard[0][0];
    }
    // 2st row
    if (gameBoard[1][0] != null && gameBoard[1][0].equals(gameBoard[1][1])
            && gameBoard[1][0].equals(gameBoard[1][2])) {
      return gameBoard[1][0];
    }
    // 3d row
    if (gameBoard[2][0] != null && gameBoard[2][0].equals(gameBoard[2][1])
            && gameBoard[2][0].equals(gameBoard[2][2])) {
      return gameBoard[2][0];
    }
    return null;
  }

  public boolean tie() {
    return hasWinner() != null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    XoBoard xoBoard = (XoBoard) o;
    return Arrays.deepEquals(gameBoard, xoBoard.gameBoard);
  }

  @Override
  public int hashCode() {
    return Arrays.deepHashCode(gameBoard);
  }

  @Override
  public String toString() {
    return "GameBoard={"
            + Arrays.deepToString(gameBoard)
            + '}';
  }

  // дополнительный метод toString() может пригодится в этом классе, но он не обязателен
}


