package academy.kovalevskyi.algorithms.week1.day1;

import academy.kovalevskyi.algorithms.week1.day0.GraphBinaryNode;
import academy.kovalevskyi.algorithms.week1.day0.IntGraphHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GraphHelper2Test {

  @Test
  void includesDepthFirstSearch() {
    var node = new GraphBinaryNode<>(new GraphBinaryNode<>(null,
            IntGraphHelper.createNode(9), 2),
            new GraphBinaryNode<>(IntGraphHelper.createNode(4),
                    IntGraphHelper.createNode(7), 6), 5);
    /* Binary tree
          5
       2     6
         9 4   7
     */

    Assertions.assertTrue(GraphHelper2.includesDepthFirstSearch(node, 4));
    Assertions.assertTrue(GraphHelper2.includesDepthFirstSearch(node, 5));
    Assertions.assertTrue(GraphHelper2.includesDepthFirstSearch(node, 2));
    Assertions.assertFalse(GraphHelper2.includesDepthFirstSearch(node, 0));
    Assertions.assertFalse(GraphHelper2.includesDepthFirstSearch(node, -4));
  }

  @Test
  void includesBreathFirstSearch() {
    var node = new GraphBinaryNode<>(new GraphBinaryNode<>(null,
            IntGraphHelper.createNode(9), 2),
            new GraphBinaryNode<>(IntGraphHelper.createNode(4),
                    IntGraphHelper.createNode(7), 6), 5);
    /* Binary tree
          5
       2     6
         9 4   7
     */

    Assertions.assertTrue(GraphHelper2.includesBreathFirstSearch(node, 4));
    Assertions.assertTrue(GraphHelper2.includesBreathFirstSearch(node, 5));
    Assertions.assertTrue(GraphHelper2.includesBreathFirstSearch(node, 2));
    Assertions.assertFalse(GraphHelper2.includesBreathFirstSearch(node, 0));
    Assertions.assertFalse(GraphHelper2.includesBreathFirstSearch(node, -4));
  }

  @Test
  void includesDepthFirstSearchRecursive() {
    var node = new GraphBinaryNode<>(new GraphBinaryNode<>(null,
            IntGraphHelper.createNode(9), 2),
            new GraphBinaryNode<>(IntGraphHelper.createNode(4),
                    IntGraphHelper.createNode(7), 6), 5);
    /* Binary tree
          5
       2     6
         9 4   7
     */
    Assertions.assertTrue(GraphHelper2.includesDepthFirstSearchRecursive(node, 4));
    Assertions.assertTrue(GraphHelper2.includesDepthFirstSearchRecursive(node, 5));
    Assertions.assertTrue(GraphHelper2.includesDepthFirstSearchRecursive(node, 2));
    Assertions.assertFalse(GraphHelper2.includesDepthFirstSearchRecursive(node, 0));
    Assertions.assertFalse(GraphHelper2.includesDepthFirstSearchRecursive(node, -4));
  }
}