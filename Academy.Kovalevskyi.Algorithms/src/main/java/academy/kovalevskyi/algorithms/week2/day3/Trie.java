package academy.kovalevskyi.algorithms.week2.day3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Trie {
  private static final ForkJoinPool POOL = ForkJoinPool.commonPool();
  private final TrieNode root = new TrieNode();

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.add("test");
    System.out.println();
  }

  public void add(String word) {
    var tmpRoot = root;
    for (int i = 0; i < word.length(); i++) {
      tmpRoot = tmpRoot.children.computeIfAbsent(word.charAt(i),
              character -> {
                var node = new TrieNode();
                node.value = String.valueOf(character);
                return node;
              });
    }
    tmpRoot.value = word;
    tmpRoot.finalCharacter = true;
  }

  public boolean containsExact(String word) {
    var tmpRoot = root;
    for (int i = 0; i < word.length(); i++) {
      tmpRoot = tmpRoot.children.get(word.charAt(i));
      if (tmpRoot == null) {
        return false;
      }
    }
    return tmpRoot.finalCharacter;
  }

  public int count() {
    return POOL.invoke(new WordCountAction(root));
  }

  public List<String> startsWith(String prefix) {
    System.out.println(prefix);

    var tmpRoot = root;
    for (int i = 0; i < prefix.length(); i++) {
      tmpRoot = tmpRoot.children.get(prefix.charAt(i));
      if (tmpRoot == null) {
        return new ArrayList<>();
      }
    }
    return POOL.invoke(new WordSearchAction(tmpRoot));
  }
}
