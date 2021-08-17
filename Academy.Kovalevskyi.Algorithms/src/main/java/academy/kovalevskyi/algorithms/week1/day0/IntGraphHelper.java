package academy.kovalevskyi.algorithms.week1.day0;

public class IntGraphHelper {

  public static GraphBinaryNode<Integer> createNode(Integer value) {
    return new GraphBinaryNode<>(null, null, value);
  }

  public static GraphBinaryNode<Integer> addNode(final GraphBinaryNode<Integer> root,
                                                 Integer value) {
    if (root == null) {
      return null;
    }
    GraphBinaryNode<Integer> newNode;
    if (value > root.value()) {
      if (root.right() != null) {
        newNode = new GraphBinaryNode<>(clone(root.left()), addNode(root.right(), value),
                root.value());
      } else {
        newNode = new GraphBinaryNode<>(clone(root.left()), createNode(value), root.value());
      }
    } else {
      if (root.left() != null) {
        newNode = new GraphBinaryNode<>(addNode(root.left(), value), clone(root.right()),
                root.value());
      } else {
        newNode = new GraphBinaryNode<>(createNode(value), clone(root.right()), root.value());
      }
    }
    return newNode;
  }

  public static boolean contains(GraphBinaryNode<Integer> root, Integer value) {
    if (root == null) {
      return false;
    }
    if (root.value().equals(value)) {
      return true;
    } else {
      if (contains(root.left(), value)) {
        return true;
      } else {
        return contains(root.right(), value);
      }
    }
  }

  private static GraphBinaryNode<Integer> clone(GraphBinaryNode<Integer> root) {
    if (root == null) {
      return null;
    }
    return new GraphBinaryNode<>(clone(root.left()),
            clone(root.right()), root.value());
  }
}
