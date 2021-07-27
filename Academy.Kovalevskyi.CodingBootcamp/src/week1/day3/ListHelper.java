package week1.day3;

import java.util.function.Function;

public class ListHelper {

    public static <T> int length(ListNode<T> someNode) {
        ListNode<T> node = someNode;
        int counter = 0;
        while (node != null) {
            counter++;
            node = node.getPrev();
        }
        node = someNode.getNext();
        while (node != null) {
            counter++;
            node = node.getNext();
        }
        return counter;
    }

    public static <T> ListNode<T> addToEnd(ListNode<T> someNode, T newValue) {
        ListNode<T> newNodes = new ListNode<>(null, null, newValue);
        if (someNode == null) {
            return newNodes;
        }
        while (someNode.getNext() != null) {
            someNode = someNode.getNext();
        }
        someNode.setNext(newNodes);
        newNodes.setPrev(someNode);
        return newNodes;
    }

    public static <T> ListNode<T> addToStart(ListNode<T> someNode, T newValue) {
        ListNode<T> newNodes = new ListNode<>(null, null, newValue);
        if (someNode == null) {
            return newNodes;
        }
        while (someNode.getPrev() != null) {
            someNode = someNode.getPrev();
        }
        someNode.setPrev(newNodes);
        newNodes.setNext(someNode);
        return newNodes;
    }

    public static <T> boolean contains(ListNode<T> someNode, T value) {
        ListNode<T> node = someNode;
        while (node != null) {
            if (value.equals(node.getValue())) {
                return true;
            }
            node = node.getPrev();
        }
        node = someNode.getNext();
        while (node != null) {
            if (value.equals(node.getValue())) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    public static <T, R> ListNode<R> map(ListNode<T> someNode, Function<T, R> mapFunction) {
        ListNode<R> newNodes = null;
        ListNode<T> node = someNode;
        while (node != null) {
            newNodes = addToStart(newNodes, mapFunction.apply(node.getValue()));
            node = node.getPrev();
        }
        node = someNode.getNext();
        while (node != null) {
            newNodes = addToEnd(newNodes, mapFunction.apply(node.getValue()));
            node = node.getNext();
        }
        return newNodes;
    }

    public static <T> ListNode<T> insertAfter(ListNode<T> prev, T newValue) {
        ListNode<T> prior = prev;
        ListNode<T> second = prev.getNext();

        ListNode<T> newNodes = new ListNode<>(prior, second, newValue);

        if (prior != null) {
            prior.setNext(newNodes);
        }
        if (second != null) {
            second.setPrev(newNodes);
        }
        return newNodes;
    }

    public static <T> void insertAfter(ListNode<T> prev, T[] newValues) {
        for (T value : newValues) {
            prev = insertAfter(prev, value);
        }
    }

    public static <T> T delete(ListNode<T> current) {
        final T value = current.getValue();
        ListNode<T> prior = current.getPrev();
        ListNode<T> second = current.getNext();

        current.setNext(null);
        current.setPrev(null);

        if (prior != null) {
            prior.setNext(second);
        }
        if (second != null) {
            second.setPrev(prior);
        }
        return value;
    }

    public static <T> ListNode<T> firstNode(ListNode<T> someNode) {
        ListNode<T> node = someNode;
        while (node.getPrev() != null) {
            node = node.getPrev();
        }
        return node;
    }

}
