package academy.kovalevskyi.algorithms.week1.day1;

import java.util.LinkedHashSet;
import java.util.Set;

public class XoHelper {
  private static final Set<XoBoard> xoBoards = new LinkedHashSet<>();

  public static void main(String[] args) {
    gen(new XoBoard(), XoFigure.figureX);
    System.out.println(xoBoards.size());
  }

  public static Set<XoBoard> generateEndStates() {
    gen(new XoBoard(), XoFigure.figureX);
    return xoBoards;
  }

  private static void gen(XoBoard board, XoFigure figure) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board.getFigure(i, j) == null) {
          XoBoard xoBoardNew = new XoBoard(board);
          xoBoardNew.setFigure(i, j, figure);
          xoBoards.add(xoBoardNew);
          gen(xoBoardNew, figure == XoFigure.figureX ? XoFigure.figureO : XoFigure.figureX);
        }
      }
    }
  }
}
