package academy.kovalevskyi.algorithms.week0.day0;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TasksTest {

  @Test
  void sameCharactersSorting() {
    Assertions.assertTrue(Tasks.sameCharactersSorting("abclpd", "lacpbd"), "abclpd == lacpbd");
    Assertions.assertFalse(Tasks.sameCharactersSorting("abcgpd", "lacpbd"), "abcgpd != lacpbd");
    Assertions.assertFalse(Tasks.sameCharactersSorting("dAdH", "dFx/"), "abcgpd != lacpbd");
  }

  @Test
  void sameCharactersO1() {
    Assertions.assertTrue(Tasks.sameCharactersO1("abclpd", "lacpbd"), "abclpd == lacpbd");
    Assertions.assertFalse(Tasks.sameCharactersO1("abcgpd", "lacpbd"), "abcgpd != lacpbd");
    //Проверка если метод просто суммирует
    Assertions.assertFalse(Tasks.sameCharactersO1("dAdH", "dFx/"), "\"dAdH\" != \"dFx/\"");
  }
}