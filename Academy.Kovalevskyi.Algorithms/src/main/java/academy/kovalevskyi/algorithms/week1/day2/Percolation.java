package academy.kovalevskyi.algorithms.week1.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Percolation {

  private Graph graph;
  private final List<Node> lastNode = new ArrayList<>();
  private final List<Node> firstNode = new ArrayList<>();

  public Percolation(boolean[][] field) {
    this.graph = generateGraph(field);
  }

  public Graph generateGraph(boolean[][] field) {
    Set<Node> set = new HashSet<>();
    Node[][] nodeTemp = new Node[field.length][field[0].length];
    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field[i].length; j++) {
        if (field[i][j]) {
          nodeTemp[i][j] = new Node();
        }
      }
    }
    for (int y = 0; y < field.length; y++) {
      for (int x = 0; x < field[y].length; x++) {
        if (nodeTemp[y][x] != null) {
          if (x + 1 < field[y].length && nodeTemp[y][x + 1] != null) {
            nodeTemp[y][x].neighbours.add(nodeTemp[y][x + 1]);
          }
          if (y != 0 && nodeTemp[y - 1][x] != null) {
            nodeTemp[y][x].neighbours.add(nodeTemp[y - 1][x]);
          }
          if (y + 1 < field.length && nodeTemp[y + 1][x] != null) {
            nodeTemp[y][x].neighbours.add(nodeTemp[y + 1][x]);
          }
          if (x != 0 && nodeTemp[y][x - 1] != null) {
            nodeTemp[y][x].neighbours.add(nodeTemp[y][x - 1]);
          }
          set.add(nodeTemp[y][x]);
        }
      }
    }
    for (Node[] nodes : nodeTemp) {
      if (nodes[nodeTemp[0].length - 1] != null) {
        lastNode.add(nodes[nodeTemp[0].length - 1]);
      }
      if (nodes[0] != null) {
        firstNode.add(nodes[0]);
      }
    }
    return Graph.generateGraph(set);
  }

  public boolean percolate() {
    if (lastNode.isEmpty() || firstNode.isEmpty()) {
      return false;
    }
    for (Node last : lastNode) {
      for (Node first : firstNode) {
        if (graph.getComponentId(last) == graph.getComponentId(first)) {
          return true;
        }
      }
    }
    return false;
  }
}