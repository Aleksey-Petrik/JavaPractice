package academy.kovalevskyi.algorithms.week2.day3;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class TrieTest {
  private final Trie trie = new Trie();

  @BeforeEach
  void setUp() {
    trie.add("test");
    trie.add("test2");
    trie.add("olloolo");
    trie.add("69132812");
    trie.add("karamba");
  }

  @Test
  void count() {
    Truth.assertWithMessage("ERROR").that(trie.count()).isEqualTo(5);
    trie.add("test3");
    Truth.assertWithMessage("ERROR").that(trie.count()).isEqualTo(6);
  }

  @Test
  void startsWith() {
    List<String> words = trie.startsWith("te");
    Truth.assertWithMessage("ERROR").that(words.size()).isEqualTo(2);
    System.out.println(words);

    trie.add("test3");
    trie.add("teremok");
    trie.add("test334");
    words = trie.startsWith("t");
    Truth.assertWithMessage("ERROR").that(words.size()).isEqualTo(5);
    System.out.println(words);

    trie.add("Though");
    trie.add("tries");
    trie.add("be");
    trie.add("can");
    trie.add("keyed");
    trie.add("by");
    trie.add("character");
    trie.add("strings");
    words = trie.startsWith("");
    Truth.assertWithMessage("ERROR").that(words.size()).isEqualTo(16);
    System.out.println(words);

  }
}