package academy.kovalevskyi.algorithms.week1.day4;

import java.util.HashMap;
import java.util.Map;

public class Node {
  public Map<Node, Integer> connections = new HashMap<>();
  public Integer distance = Integer.MAX_VALUE;

  private static int count;
  private final int id;

  public Node() {
    this.id = count++;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node node = (Node) o;
    return id == node.id;
  }

  @Override
  public int hashCode() {
    return Integer.hashCode((id + 3) * 29);
  }

  @Override
  public String toString() {
    return "Node{"
            + "id="
            + id
            + '}';
  }
}
