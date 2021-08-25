package academy.kovalevskyi.algorithms.week2.day0;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class IntTreeHelperTest {

  @Test
  void addNode() {
    IntTreeNode treeNode7 = new IntTreeNode(40, 40, 1, 1, 1, null, null);
    IntTreeNode treeNode6 = new IntTreeNode(35, 75, 2, 2, 1, null, treeNode7);
    IntTreeNode treeNode5 = new IntTreeNode(19, 19, 1, 1, 1, null, null);
    IntTreeNode treeNode4 = new IntTreeNode(5, 5, 1, 1, 1, null, null);
    IntTreeNode treeNode3 = new IntTreeNode(30, 124, 4, 3, 2, treeNode5, treeNode6);
    IntTreeNode treeNode2 = new IntTreeNode(20,25, 2, 2, 1, treeNode4, null);
    IntTreeNode treeNode1 = new IntTreeNode(26, 175,7, 4, 3, treeNode2, treeNode3);

    IntTreeHelper.printTree(treeNode1);
    //IntTreeHelper.printTree(IntTreeHelper.addNode(treeNode1,2));
    var temp = IntTreeHelper.addNode(treeNode1,2);
    IntTreeHelper.printTree(IntTreeHelper.addNode(temp,1));
    System.out.println(IntTreeHelper.getSortedList(treeNode1));
    System.out.println(IntTreeHelper.hasValue(treeNode1, 25));
    System.out.println(IntTreeHelper.hasValue(treeNode1, 5));
  }

  @Test
  void addNode2() {
    List<Integer> list = new ArrayList<>();
    list.add(-2);
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(10);
    list.add(12);

    IntTreeNode nodes = null;
    for(Integer node : list){
      nodes = IntTreeHelper.addNode(nodes, node);
    }
    IntTreeHelper.printTree(nodes);

  }

  @Test
  void addNode3() {
    IntTreeNode nodes = null;
    nodes = IntTreeHelper.addNode(nodes,26);
    nodes = IntTreeHelper.addNode(nodes,20);
    nodes = IntTreeHelper.addNode(nodes,30);
    //nodes = IntTreeHelper.addNode(nodes,5);
    //nodes = IntTreeHelper.addNode(nodes,19);
   nodes = IntTreeHelper.addNode(nodes,35);
    //nodes = IntTreeHelper.addNode(nodes,40);
   //nodes = IntTreeHelper.addNode(nodes,2);
   //nodes = IntTreeHelper.addNode(nodes,1);

    IntTreeHelper.printTree(nodes);

  }

  @Test
  void addNode4() {
    IntTreeNode nodes = null;
    nodes = IntTreeHelper.addNode(nodes,26);
    nodes = IntTreeHelper.addNode(nodes,20);
    nodes = IntTreeHelper.addNode(nodes,30);
    nodes = IntTreeHelper.addNode(nodes,5);
    nodes = IntTreeHelper.addNode(nodes,19);
    nodes = IntTreeHelper.addNode(nodes,35);
    nodes = IntTreeHelper.addNode(nodes,40);
    nodes = IntTreeHelper.addNode(nodes,2);
    nodes = IntTreeHelper.addNode(nodes,1);
    nodes = IntTreeHelper.addNode(nodes,29);
    IntTreeHelper.printTree(nodes);


    nodes = IntTreeHelper.rotateLeft(nodes);
    IntTreeHelper.printTree(nodes);
    nodes = IntTreeHelper.rotateRight(nodes);
    IntTreeHelper.printTree(nodes);

  }

  @Test
  void generateBalanceTree() {
    IntTreeNode nodes = null;
    nodes = IntTreeHelper.addNode(nodes,10);
    nodes = IntTreeHelper.addNode(nodes,-2);
    nodes = IntTreeHelper.addNode(nodes,12);
    nodes = IntTreeHelper.addNode(nodes,1);
    nodes = IntTreeHelper.addNode(nodes,2);
    nodes = IntTreeHelper.addNode(nodes,3);

    IntTreeHelper.printTree(nodes);
    nodes = IntTreeHelper.rotateRight(nodes);
    IntTreeHelper.printTree(nodes);
    nodes = IntTreeHelper.rotateLeft(nodes);
    IntTreeHelper.printTree(nodes);
    nodes = IntTreeHelper.rotateLeft(nodes);
    IntTreeHelper.printTree(nodes);
  }

}