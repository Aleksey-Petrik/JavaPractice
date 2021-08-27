package academy.kovalevskyi.algorithms.week2.day0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IntTreeHelper {
  public static IntTreeNode createNode(int value) {
    return new IntTreeNode(value, value, 1, 1, 1, null, null);
  }

  public static IntTreeNode rotateLeft(IntTreeNode root) {
    var leftNode = root.left();
    var rightNode = root.right();

    var nodeNew = new IntTreeNode(rightNode.value(), 1, 1, 1, 1,
            new IntTreeNode(root.value(), 1, 1, 1, 1, clone(leftNode), clone(rightNode.left())),
            clone(rightNode.right()));

    return nodeNew;
  }

  public static IntTreeNode rotateRight(IntTreeNode root) {
    var leftNode = root.left();
    var rightNode = root.right();
    var nodeNew = new IntTreeNode(leftNode.value(), 1, 1,
            1, 1, clone(leftNode.left()),
            new IntTreeNode(root.value(), 1, 1,
                    1, 1, clone(leftNode.right()), clone(rightNode))
    );

    return nodeNew;
  }

  public static IntTreeNode addNode(IntTreeNode root, int value) {
    if (root == null) {
      return createNode(value);
    }

    var currentNode = value > root.value()
            ? addNode(root.right(), value)
            : addNode(root.left(), value);
    var cloneNode = value > root.value()
            ? clone(root.left())
            : clone(root.right());

    int valMaxCloneNode = cloneNode != null ? cloneNode.maxDepth() : 1;
    int valMinCloneNode = cloneNode != null ? cloneNode.minDepth() : 0;

    int resultMax = root.maxDepth() == currentNode.maxDepth()
            ? Math.max(currentNode.maxDepth(), valMaxCloneNode) + 1
            : root.maxDepth();


    int resultMin = Math.max(currentNode.minDepth(), valMinCloneNode) + 1;
    //int resultMin = Math.min(root.minDepth(), valMinCloneNode) + 1;


    if (value > root.value()) {
      return new IntTreeNode(root.value(),
              root.sum() + value,
              root.count() + 1,
              resultMax, resultMin,
              cloneNode, currentNode);

    } else {
      return new IntTreeNode(root.value(),
              root.sum() + value,
              root.count() + 1,
              resultMax, resultMin,
              currentNode, cloneNode);
    }

  }

  private static IntTreeNode clone(IntTreeNode root) {
    return root != null
            ? new IntTreeNode(root.value(),
            root.sum(), root.count(), root.maxDepth(),
            root.minDepth(), root.left(), root.right())
            : null;
  }

  public static boolean needBalancing(IntTreeNode root) {
    printTree(root);
    if (root.maxDepth() == root.count() && (root.minDepth() - 1 == 1)) {
      return false;
    }
    return root.maxDepth() > root.minDepth() + 1;
  }

  public static List<Integer> getSortedList(IntTreeNode root) {
    var queue = new LinkedList<IntTreeNode>();
    var result = new ArrayList<Integer>();
    queue.add(root);
    while (!queue.isEmpty()) {
      var node = queue.poll();
      if (node != null) {
        if (node.left() != null) {
          queue.add(node.left());
        }
        if (node.right() != null) {
          queue.add(node.right());
        }
        result.add(node.value());
      }
    }
    result.sort(Integer::compareTo);
    return result;
  }

  public static IntTreeNode generateBalanceTree(IntTreeNode root) {
    //printTree(root);
    List<Integer> list = getSortedList(root);
    //IntTreeNode nodes = null;
    IntTreeNode nodes = addNode(null, root.value());
    for (Integer node : list) {
      if (root.value() != node) {
        nodes = addNode(nodes, node);
      }
    }
    printTree(nodes);
    return nodes;
  }

  public static boolean hasValue(IntTreeNode root, int value) {
    if (root == null) {
      return false;
    }
    if (root.value() == value) {
      return true;
    }
    return value > root.value() ? hasValue(root.right(), value) :
            hasValue(root.left(), value);
  }

  public static void printTree(IntTreeNode rootNode) {
    var list = new ArrayList<IntTreeNode>();
    var globalStack = new Stack<IntTreeNode>(); // общий стек для значений дерева
    globalStack.push(rootNode);
    int gaps = 32; // начальное значение расстояния между элементами
    boolean isRowEmpty = false;
    String separator = "-----------------------------------------------------------------";
    System.out.println(separator);
    while (!isRowEmpty) {
      var localStack = new Stack<IntTreeNode>();
      isRowEmpty = true;
      System.out.print(" ".repeat(gaps));
      while (!globalStack.isEmpty()) {
        var node = globalStack.pop();
        if (node != null) {
          System.out.print(node.value());
          list.add(node);
          localStack.push(node.left());
          localStack.push(node.right());
          if (node.left() != null || node.right() != null) {
            isRowEmpty = false;
          }
        } else {
          System.out.print("__");
          localStack.push(null);
          localStack.push(null);
        }
        System.out.print(" ".repeat(gaps * 2 - 2));
      }
      System.out.println();
      gaps /= 2;
      while (!localStack.isEmpty()) {
        globalStack.push(localStack.pop());
      }
    }
    System.out.println(separator);
    list.forEach(node -> {
      System.out.println("Node" + node.value()
              + " left=" + node.left()
              + " right=" + node.right()
              + " sum="
              + node.sum()
              + " count=" + node.count()
              + " maxDepth=" + node.maxDepth()
              + " minDepth=" + node.minDepth());
    });
  }
}