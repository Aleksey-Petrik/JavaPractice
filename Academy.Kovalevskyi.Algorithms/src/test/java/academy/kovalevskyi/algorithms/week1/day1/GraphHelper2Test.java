package academy.kovalevskyi.algorithms.week1.day1;

import academy.kovalevskyi.algorithms.week1.day0.GraphBinaryNode;
import academy.kovalevskyi.algorithms.week1.day0.IntGraphHelper;
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

    System.out.println(GraphHelper2.includesDepthFirstSearch(node, 0));
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

    System.out.println(GraphHelper2.includesBreathFirstSearch(node, 0));
  }
}