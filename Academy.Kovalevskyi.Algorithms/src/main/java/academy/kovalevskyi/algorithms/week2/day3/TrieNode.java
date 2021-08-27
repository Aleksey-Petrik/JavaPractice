package academy.kovalevskyi.algorithms.week2.day3;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
  public String value = "";
  public Map<Character, TrieNode> children = new HashMap<>();
  public boolean finalCharacter = false;
}
