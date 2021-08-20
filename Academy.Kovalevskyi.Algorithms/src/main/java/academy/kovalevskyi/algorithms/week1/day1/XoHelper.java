package academy.kovalevskyi.algorithms.week1.day1;

import java.util.HashSet;
import java.util.Set;

public class XoHelper {

  public static Set<XoBoard> generateEndStates() {
    return generateEndStatesVlob();
  }

  public static Set<XoBoard> generateEndStatesVlob() {
    Set<XoBoard> set = new HashSet<>();
    XoFigure[] pc = {null, XoFigure.figureO, XoFigure.figureX};
    XoFigure[][] setArray = new XoFigure[3][3];
    XoFigure[] c = new XoFigure[9];
    for (int i = 0; i < 9; i++) {
      c[i] = pc[0];
    }
    for (int i = 0; i < 3; i++) {
      c[0] = pc[i];
      for (int j = 0; j < 3; j++) {
        c[1] = pc[j];
        for (int k = 0; k < 3; k++) {
          c[2] = pc[k];
          for (int l = 0; l < 3; l++) {
            c[3] = pc[l];
            for (int m = 0; m < 3; m++) {
              c[4] = pc[m];
              for (int n = 0; n < 3; n++) {
                c[5] = pc[n];
                for (int o = 0; o < 3; o++) {
                  c[6] = pc[o];
                  for (int p = 0; p < 3; p++) {
                    c[7] = pc[p];
                    for (int q = 0; q < 3; q++) {
                      c[8] = pc[q];
                      int countx = 0;
                      int county = 0;
                      for (int r = 0; r < 9; r++) {
                        if (c[r] == XoFigure.figureX) {
                          countx = countx + 1;
                        } else if (c[r] == XoFigure.figureO) {
                          county = county + 1;
                        }
                      }
                      XoBoard xoBoard = new XoBoard(new XoFigure[][]{
                              {c[0], c[1], c[2]},
                              {c[3], c[4], c[5]},
                              {c[6], c[7], c[8]}});
                      set.add(xoBoard);
                      // if (Math.abs(countx - county) < 2) {
                      // if (won(c, pc[2]) + won(c, pc[1]) == 1) {
                      // XoBoard xoBoard = new XoBoard(new XoFigure[][]{
                      // {c[0], c[1], c[2]},
                      // {c[3], c[4], c[5]},
                      // {c[6], c[7], c[8]}});
                      // set.add(xoBoard);
                      // System.out.println(c[0] + " " + c[1] + " " + c[2]);
                      // System.out.println(c[3] + " " + c[4] + " " + c[5]);
                      // System.out.println(c[6] + " " + c[7] + " " + c[8]);
                      // System.out.println("*******************************************");
                      // }
                      // }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return set;
  }
  /*
  public static int won(XoFigure[] c, XoFigure n) {
    if ((c[0] == n) && (c[1] == n) && (c[2] == n))
      return 1;
    else if ((c[3] == n) && (c[4] == n) && (c[5] == n))
      return 1;
    else if ((c[6] == n) && (c[7] == n) && (c[8] == n))
      return 1;
    else if ((c[0] == n) && (c[3] == n) && (c[6] == n))
      return 1;
    else if ((c[1] == n) && (c[4] == n) && (c[7] == n))
      return 1;
    else if ((c[2] == n) && (c[5] == n) && (c[8] == n))
      return 1;
    else if ((c[0] == n) && (c[4] == n) && (c[8] == n))
      return 1;
    else if ((c[2] == n) && (c[4] == n) && (c[6] == n))
      return 1;
    else
      return 0;
  }
   */
}
