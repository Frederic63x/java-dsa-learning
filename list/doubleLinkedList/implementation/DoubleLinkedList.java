@SuppressWarnings("unchecked")
public class DoubleLinkedList<T> /* implements LinkedListInterface<T> */{

    int size = 0;
    Node<T> head = null;
    Node<T> tail = null;

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addInHead(Node<T> newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        if (size == 0) {
            tail = head;
        }

        size++;
    }

    public void addInTail(Node<T> newNode) {
        if (head == null) {
            addInHead(newNode);
        } else {
            Node<T> trav = head;
            while (trav.next != null) {
                trav = trav.next;
            }

            trav.next = newNode;
            newNode.previous = trav;
            size++;
        }

        tail = newNode;
    }

    public void addAtIndex(int index, Node<T> newNode) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index must be >= 0");
        } else if (index > size) {
            throw new IndexOutOfBoundsException(
                "Index must be <= size. Index: " + index + " Size: " + size
            );
        }

        if (index == 0) {
            addInHead(newNode);
        } else if (index == size) {
            addInTail(newNode);
        } else {
            Node<T> trav1;
            Node<T> trav2;
            int trav2Index;

            if (index <= size / 2) {
                trav1 = head;
                trav2 = trav1.next;
                trav2Index = 1;

                while (trav2Index != index) {
                    trav1 = trav1.next;
                    trav2 = trav2.next;
                    trav2Index++;
                }

                newNode.next = trav2;
                trav2.previous = newNode;

                newNode.previous = trav1;
                trav1.next = newNode;
            } else {
                trav1 = tail;
                trav2 = trav1.previous;
                trav2Index = size - 1;

                while (trav2Index != index) {
                    trav1 = trav1.previous;
                    trav2 = trav2.previous;
                    trav2Index--;
                }

                newNode.previous = trav2;
                trav2.next = newNode;

                newNode.next = trav1;
                trav1.previous = newNode;
            }

            size++;
        }
    }

    public Node<T> removeHead() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException(
                "The list is empty, nothing to remove"
            );
        }

        Node<T> temp = head;
        head = head.next;

        if (head != null) {
            head.previous = null;
        }

        size--;
        if (size == 0) {
            tail = null;
        }

        return temp;
    }

    public Node<T> removeTail() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException(
                "The list is empty, nothing to remove"
            );
        }

        Node<T> temp = tail;
        tail = tail.previous;

        if (tail != null) {
            tail.next = null;
        }

        size--;
        if (size == 0) {
            head = null;
        }

        return temp;
    }

    public void printList() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException(
                "The list is empty, nothing to print"
            );
        }

        Node<T> trav = head;
        System.out.println("index: 0 " + trav);

        for (int i = 1; i < size; i++) {
            trav = trav.next;
            System.out.println("index: " + i + " " + trav);
        }
    }
}
