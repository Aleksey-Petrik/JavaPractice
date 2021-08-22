package academy.kovalevskyi.algorithms.week1.day4;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;

class NetworkPathFinderTest {

  @Test
  void shortestPath() {
    Node node1 = new Node();
    Node node2 = new Node();
    Node node3 = new Node();
    Node node6 = new Node();

    node1.connections.put(node2, 7);
    node1.connections.put(node3, 9);
    node1.connections.put(node6, 14);

    Node node4 = new Node();
    node2.connections.put(node1, 7);
    node2.connections.put(node3, 10);
    node2.connections.put(node4, 15);

    node3.connections.put(node1, 9);
    node3.connections.put(node2, 10);
    node3.connections.put(node4, 11);
    node3.connections.put(node6, 2);

    Node node5 = new Node();
    node4.connections.put(node2, 15);
    node4.connections.put(node3, 11);
    node4.connections.put(node5, 6);

    node5.connections.put(node4, 6);
    node5.connections.put(node6, 9);

    node6.connections.put(node1, 14);
    node6.connections.put(node3, 2);
    node6.connections.put(node5, 9);

    Truth.assertWithMessage("Error")
            .that(NetworkPathFinder.shortestPath(node1, node5))
            .isEqualTo(20);
  }

  @Test
  void shortestPath2() {
    Node node1 = new Node();
    Node node2 = new Node();

    node1.connections.put(node2, 5);
    node2.connections.put(node1, 5);

    Truth.assertWithMessage("Error")
            .that(NetworkPathFinder.shortestPath(node1, node2))
            .isEqualTo(5);
  }

}