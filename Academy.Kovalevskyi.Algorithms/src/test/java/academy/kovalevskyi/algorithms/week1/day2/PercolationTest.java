package academy.kovalevskyi.algorithms.week1.day2;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;

class PercolationTest {

  @Test
  void generateGraph2x2() {
    boolean[][] array = {
            {true, true},
            {true, true}};
    Percolation percolation = new Percolation(array);
    Truth.assertWithMessage("Не прошел тест").that(percolation.percolate()).isTrue();
  }

  @Test
  void generateGraph3x3() {
    boolean[][] array = {
            {true, true, false},
            {false, true, false},
            {false, true, true}};
    Percolation percolation = new Percolation(array);
    Truth.assertWithMessage("Не прошел тест").that(percolation.percolate()).isTrue();
  }

  @Test
  void generateGraph4x4() {
    boolean[][] array = {
            {true, true, true, true},
            {true, true, true, true},
            {true, true, true, true},
            {true, true, true, true}};
    Percolation percolation = new Percolation(array);
    Truth.assertWithMessage("Не прошел тест").that(percolation.percolate()).isTrue();
  }

  @Test
  void generateGraph4x4_2() {
    boolean[][] array = {
            {true, true, false},
            {false, true, false},
            {false, true, true}};
    Percolation percolation = new Percolation(array);
    System.out.println(percolation.percolate());
    Truth.assertWithMessage("Не прошел тест").that(percolation.percolate()).isTrue();
  }

  @Test
  void generateGraph4x4_3() {
    boolean[][] array = {
            {true, false, false, true},
            {true, false, false, true},
            {true, false, false, true},
            {true, false, false, true}};
    Percolation percolation = new Percolation(array);
    Truth.assertWithMessage("Не прошел тест").that(percolation.percolate()).isFalse();
  }

  @Test
  void generateGraph4x4_4() {
    boolean[][] array = {
            {true, false, false, false},
            {true, false, true, true},
            {false, false, true, false},
            {true, true, true, false}};
    Percolation percolation = new Percolation(array);
    Truth.assertWithMessage("Не прошел тест").that(percolation.percolate()).isTrue();
  }

  @Test
  void generateGraph4x4_5() {
    boolean[][] array = {
            {true, true, false, true},
            {false, true, true, false},
            {false, true, true, false},
            {true, false, true, true}};
    Percolation percolation = new Percolation(array);
    Truth.assertWithMessage("Не прошел тест").that(percolation.percolate()).isTrue();
  }

  @Test
  void generateGraph4x4_6() {
    boolean[][] array = {
            {true, false, false, true},
            {false, true, true, false},
            {false, true, true, false},
            {true, false, false, true}};
    Percolation percolation = new Percolation(array);
    Truth.assertWithMessage("Не прошел тест").that(percolation.percolate()).isFalse();
  }
}
