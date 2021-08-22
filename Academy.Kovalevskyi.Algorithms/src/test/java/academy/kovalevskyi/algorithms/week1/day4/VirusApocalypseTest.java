package academy.kovalevskyi.algorithms.week1.day4;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;

class VirusApocalypseTest {

  @Test
  void countDays_days2() {
    Integer[][] array = new Integer[][]{
            {0, 2, 0, 2, 1},
            {0, 2, 1, 2, 0},
            {1, 1, 0, 2, 0},
            {0, 1, 0, 2, 2}};

    Truth.assertWithMessage("Error").that(VirusApocalypse.countDays(array)).isEqualTo(2);
  }

  @Test
  void countDays_notDays() {
    Integer[][] array = new Integer[][]{
            {0, 2, 0, 2, 0},
            {0, 2, 1, 2, 0},
            {1, 1, 0, 2, 0},
            {0, 1, 0, 2, 2}};

    Truth.assertWithMessage("Error").that(VirusApocalypse.countDays(array)).isEqualTo(-1);
  }

  @Test
  void countDays_notDays9() {
    Integer[][] array = new Integer[][]{
            {0, 2, 0, 2, 0},
            {0, 2, 1, 2, 0},
            {1, 2, 0, 2, 0},
            {0, 2, 0, 2, 1}};

    Truth.assertWithMessage("Error").that(VirusApocalypse.countDays(array)).isEqualTo(3);
  }
}