package academy.kovalevskyi.algorithms.week1.day0;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GraphBinaryNodeTest {

  @Test
  public void equalsGraphBinary() {
    var node1 = new GraphBinaryNode<>(new GraphBinaryNode<>(null, null, 2),
            new GraphBinaryNode<>(null, null, 4), 3);

    var node2 = new GraphBinaryNode<>(new GraphBinaryNode<>(null, null, 2),
            new GraphBinaryNode<>(null, null, 3), 1);

    GraphBinaryNode<Integer> newNode = IntGraphHelper.addNode(node1, 6);

    Assertions.assertTrue(GraphHelper.equals(node1, node2));
  }

  @Test
  public void invertGraphBinary() {
    //GraphBinaryNode<Integer> node1 = new GraphBinaryNode<>(1, null, null);
    //node1.setLeft(new GraphBinaryNode<Integer>(2, null, null));
    //node1.setRight(new GraphBinaryNode<Integer>(3, null, null));

    //node1 = GraphHelper.invertGraph(first);
  }

}