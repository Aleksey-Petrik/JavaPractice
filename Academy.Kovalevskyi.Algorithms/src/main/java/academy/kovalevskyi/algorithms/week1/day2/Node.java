package academy.kovalevskyi.algorithms.week1.day2;

import java.util.HashSet;
import java.util.Set;

public class Node {
  public final Set<Node> neighbours = new HashSet<>();
  private static int count;
  private final int id;

  public Node() {
    this.id = count++;
  }

  public Set<Node> getNeighbours() {
    return neighbours;
  }

  public static void connect(Node left, Node right) {
    left.neighbours.add(right);
    right.neighbours.add(left);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return id == ((Node) o).id;
  }

  @Override
  public int hashCode() {
    return Integer.hashCode(id);
  }

  @Override
  public String toString() {
    return "Node{"
            + "id="
            + id
            + '}';
  }
}
