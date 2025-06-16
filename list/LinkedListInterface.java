package src.list;

public interface LinkedListInterface<T> {
    public int size = 0;
    public static Node head = null;
    public Node tail = null;

    // check if the list is empty, usefull for the user and even more for almost all the other methods.
    public boolean isEmpty();

    // get the size of the list
    public int size();

    // add Node methods
    public void addInHead(Node<T> newNode);

    public void addInTail(Node<T> newNode);

    public void addAtIndex(int index, Node<T> newNode);

    // remove Node methods
    // return the removed Node
    public Node<T> removeHead();

    public Node<T> removeTail();

    public Node<T> removeAtIndex(int index);

    // get Node methods
    // return the gotten Node
    public Node<T> getHead();

    public Node<T> getTail();

    public Node<T> getAtIndex(int index);

    // print the list method.
    public void printList();
}
