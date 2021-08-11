package academy.kovalevskyi.algorithms.week0.day1;

public class Tasks {

  public static class Node {
    public Node next;
    public int value;
  }

  public static int findMiddleInOneGo(Node start) {
    Node first = start;
    Node second = start.next;
    while (second != null && second.next != null) {
      first = first.next;
      second = second.next;
    }
    return first.value;
  }

  public static boolean hasCycle(Node start) {
    Node first = start;
    Node second = start;
    while (second.next != null && second.next.next != null) {
      first = first.next;
      second = second.next.next;
      if (first == second) {
        return true;
      }
    }
    return false;
  }
}
