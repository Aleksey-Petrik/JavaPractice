package week1.day3;

public class ListNode<T> {
    private ListNode<T> prev;
    private ListNode<T> next;
    private final T value;

    public ListNode(ListNode<T> prev, ListNode<T> next, T value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public void setPrev(ListNode<T> prev) {
        this.prev = prev;
    }

    public ListNode<T> getPrev() {
        return prev;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        T prevValue = prev != null ? prev.getValue() : null;
        T nextValue = next != null ? next.getValue() : null;

        return "Node{"
                + "prevValue="
                + prevValue
                + ", nextValue="
                + nextValue
                + ", thisValue="
                + value
                + '}';
    }
}
