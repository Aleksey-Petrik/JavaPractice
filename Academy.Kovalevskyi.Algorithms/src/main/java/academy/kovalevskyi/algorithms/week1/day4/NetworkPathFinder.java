package academy.kovalevskyi.algorithms.week1.day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkPathFinder {
  private static final Map<Integer, List<Node>> mapPaths = new HashMap<>();
  private static final List<Node> currentNodes = new ArrayList<>();
  private static int sumEdge = 0;
  private static int minPath = Integer.MAX_VALUE;

  public static int shortestPath(Node start, Node end) {
    if (start.equals(end)) {
      return 0;
    }
    currentNodes.add(start);
    for (Map.Entry<Node, Integer> node : start.connections.entrySet()) {
      if (!currentNodes.contains(node.getKey())) {
        sumEdge += node.getValue();
        currentNodes.add(node.getKey());
        if (node.getKey().equals(end)) {
          createPath(node.getKey(), node.getValue());
          continue;
        }
        depthFirstSearch(node.getKey(), node.getValue(), end, currentNodes);
      }
    }
    return minPath;
  }

  private static void depthFirstSearch(Node node, int distance, Node search, List<Node> list2) {
    for (Map.Entry<Node, Integer> neighbour : node.connections.entrySet()) {
      if (!list2.contains(neighbour.getKey())) {
        sumEdge += neighbour.getValue();
        list2.add(neighbour.getKey());
        if (neighbour.getKey().equals(search)) {
          createPath(neighbour.getKey(), neighbour.getValue());
        } else {
          depthFirstSearch(neighbour.getKey(), neighbour.getValue(), search, list2);
        }
      }
    }
    sumEdge -= distance;
    list2.remove(node);
  }

  private static void createPath(Node node, int distance) {
    List<Node> buf = new ArrayList<>(currentNodes);
    mapPaths.put(sumEdge, buf);
    if (minPath > sumEdge) {
      minPath = sumEdge;
    }
    currentNodes.remove(node);
    sumEdge -= distance;
  }

}
