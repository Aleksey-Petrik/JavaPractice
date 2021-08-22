package academy.kovalevskyi.algorithms.week1.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Percolation {

  public Graph graph;
  private final List<Node> lastNode = new ArrayList<>();
  private final List<Node> firstNode = new ArrayList<>();

  public Percolation(boolean[][] field) {
    Node[][] nodes = getNodesArray(field);
    Set<Node> set = getSetOfNodesWithEdges(nodes);
    setFirstsAndLastsNode(nodes);
    this.graph = Graph.generateGraph(set);
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

  private void setFirstsAndLastsNode(Node[][] nodes) {
    for (Node[] nodeArr : nodes) {
      if (nodeArr[nodes[0].length - 1] != null) {
        lastNode.add(nodeArr[nodes[0].length - 1]);
      }
      if (nodeArr[0] != null) {
        firstNode.add(nodeArr[0]);
      }
    }
  }

  private Set<Node> getSetOfNodesWithEdges(Node[][] nodes) {
    Set<Node> resultSet = new HashSet<>();
    for (int y = 0; y < nodes.length; y++) {
      for (int x = 0; x < nodes[y].length; x++) {
        if (nodes[y][x] != null) {
          if (x + 1 < nodes[y].length && nodes[y][x + 1] != null) {
            nodes[y][x].getNeighbours().add(nodes[y][x + 1]);
          }
          if (y != 0 && nodes[y - 1][x] != null) {
            nodes[y][x].getNeighbours().add(nodes[y - 1][x]);
          }
          if (y + 1 < nodes.length && nodes[y + 1][x] != null) {
            nodes[y][x].getNeighbours().add(nodes[y + 1][x]);
          }
          if (x != 0 && nodes[y][x - 1] != null) {
            nodes[y][x].getNeighbours().add(nodes[y][x - 1]);
          }
          resultSet.add(nodes[y][x]);
        }
      }
    }
    return resultSet;
  }

  private Node[][] getNodesArray(boolean[][] field) {
    Node[][] nodeTemp = new Node[field.length][field[0].length];
    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field[i].length; j++) {
        if (field[i][j]) {
          nodeTemp[i][j] = new Node();
        }
      }
    }
    return nodeTemp;
  }
}