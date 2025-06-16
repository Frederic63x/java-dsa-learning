public class Node<T> {

    public T value;
    public Node next;
    public Node previous;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    @Override
    public String toString() {
        return ("value: " + value);
    }
}
