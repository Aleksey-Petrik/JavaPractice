package academy.kovalevskyi.algorithms.week1.day2;

import com.google.common.truth.Truth;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class GraphTest {

  @Test
  void getComponentId() {
    Node node1 = new Node();
    Node node2 = new Node();
    node1.neighbours.add(node2);
    Node node3 = new Node();
    node2.neighbours.add(node3);
    node2.neighbours.add(node1);
    node3.neighbours.add(node2);
    Node node4 = new Node();
    Node node5 = new Node();
    node4.neighbours.add(node5);
    node5.neighbours.add(node4);

    Set<Node> nodes = new HashSet<>();
    nodes.add(node1);
    nodes.add(node2);
    nodes.add(node3);
    nodes.add(node4);
    nodes.add(node5);

    Graph graph = Graph.generateGraph(nodes);

    Truth.assertWithMessage("Не прошел тест").that(graph.countComponents()).isAtLeast(2);
    Truth.assertWithMessage("Не прошел тест").that(graph.getComponentId(node1)).isAtLeast(1);
    Truth.assertWithMessage("Не прошел тест").that(graph.getComponentId(node2)).isAtLeast(1);
    Truth.assertWithMessage("Не прошел тест").that(graph.getComponentId(node3)).isAtLeast(1);
    Truth.assertWithMessage("Не прошел тест").that(graph.getComponentId(node4)).isAtLeast(2);
    Truth.assertWithMessage("Не прошел тест").that(graph.getComponentId(node5)).isAtLeast(2);

    Node node6 = new Node();
    Node node7 = new Node();
    node3.neighbours.add(node6);
    node6.neighbours.add(node3);
    node5.neighbours.add(node7);
    node7.neighbours.add(node5);
    nodes.add(node6);
    nodes.add(node7);

    Graph graph2 = Graph.generateGraph(nodes);
    Truth.assertWithMessage("Не прошел тест").that(graph2.countComponents()).isAtLeast(2);
    Truth.assertWithMessage("Не прошел тест").that(graph2.getComponentId(node1)).isAtLeast(1);
    Truth.assertWithMessage("Не прошел тест").that(graph2.getComponentId(node2)).isAtLeast(1);
    Truth.assertWithMessage("Не прошел тест").that(graph2.getComponentId(node3)).isAtLeast(1);
    Truth.assertWithMessage("Не прошел тест").that(graph2.getComponentId(node6)).isAtLeast(1);
    Truth.assertWithMessage("Не прошел тест").that(graph2.getComponentId(node4)).isAtLeast(2);
    Truth.assertWithMessage("Не прошел тест").that(graph2.getComponentId(node5)).isAtLeast(2);
    Truth.assertWithMessage("Не прошел тест").that(graph2.getComponentId(node7)).isAtLeast(2);
  }
}