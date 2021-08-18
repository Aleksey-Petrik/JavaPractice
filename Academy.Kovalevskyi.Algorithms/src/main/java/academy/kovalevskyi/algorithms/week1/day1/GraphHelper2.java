package academy.kovalevskyi.algorithms.week1.day1;

import academy.kovalevskyi.algorithms.week1.day0.GraphBinaryNode;
import java.util.LinkedList;
import java.util.Queue;

public class GraphHelper2 {

  public static boolean includesDepthFirstSearch(GraphBinaryNode<?> root, Object value) {
    LinkedList<GraphBinaryNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      GraphBinaryNode<?> node = queue.pollLast();
      System.out.println(node.value());
      if (node.value().equals(value)) {
        return true;
      }
      if (node.right() != null) {
        queue.add(node.right());
      }
      if (node.left() != null) {
        queue.add(node.left());
      }
    }
    return false;
  }

  public static boolean includesBreathFirstSearch(GraphBinaryNode<?> root, Object value) {
    LinkedList<GraphBinaryNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      GraphBinaryNode<?> node = queue.poll();
      System.out.println(node.value());
      if (node.value().equals(value)) {
        return true;
      }
      if (node.left() != null) {
        queue.add(node.left());
      }
      if (node.right() != null) {
        queue.add(node.right());
      }
    }
    return false;
  }
}
