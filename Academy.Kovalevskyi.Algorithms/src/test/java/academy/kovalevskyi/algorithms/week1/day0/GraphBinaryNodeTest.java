package academy.kovalevskyi.algorithms.week1.day0;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GraphBinaryNodeTest {

  @Test
  public void equalsGraphBinary() {
    var node1 = new GraphBinaryNode<>(new GraphBinaryNode<>(null, null, 2),
            new GraphBinaryNode<>(null, null, 4), 3);
    var node2 = new GraphBinaryNode<>(new GraphBinaryNode<>(null, null, 2),
            new GraphBinaryNode<>(null, null, 3), 4);
    GraphBinaryNode<Integer> node3 = IntGraphHelper.addNode(node1, 6);
    //true = node1 == node2
    Assertions.assertTrue(GraphHelper.equals(node1, node2));
    //false = node1 != node3
    Assertions.assertFalse(GraphHelper.equals(node1, node3));
    //contains
    var node = new GraphBinaryNode<>(new GraphBinaryNode<>(null, IntGraphHelper.createNode(9), 2),
            new GraphBinaryNode<>(IntGraphHelper.createNode(4), IntGraphHelper.createNode(7), 6), 5);
    //true find elem 6
    Assertions.assertTrue(IntGraphHelper.contains(node,6));
    //false not find 8
    Assertions.assertFalse(IntGraphHelper.contains(node,8));
  }

  @Test
  public void invertGraphBinary() {
    var node = new GraphBinaryNode<>(new GraphBinaryNode<>(null, IntGraphHelper.createNode(9), 2),
            new GraphBinaryNode<>(IntGraphHelper.createNode(4), IntGraphHelper.createNode(7), 6), 5);
    /* Binary tree
          5
       2     6
         9 4   7
     */
    var actualNode = GraphHelper.invertGraph(node);
    /* Binary tree
          5
       6     2
     7   4 9
    */
    var expectedNode = new GraphBinaryNode<>(new GraphBinaryNode<>(IntGraphHelper.createNode(7), IntGraphHelper.createNode(4), 6),
            new GraphBinaryNode<>(IntGraphHelper.createNode(9), null, 2), 9);
    //true = actualNode == expectedNode
    Assertions.assertTrue(GraphHelper.equals(actualNode, expectedNode));
  }

}