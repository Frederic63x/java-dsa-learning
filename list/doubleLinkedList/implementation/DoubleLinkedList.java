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

        // if this is the first Node added
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
        }

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

    public Node<T> removeHead() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException(
                "The list is empty, nothing to remove"
            );
        }

        Node<T> temp = head;
        head = head.next;
        head.previous = null; // otherwise the old head would be pinted by the new head.previous (so not garbage collected)

        size--;

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
        tail.next = null; // same as the head, the old tail would be pointed by the new tail.next

        size--;

        return temp;
    }

    public Node<T> removeAtIndex(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException(
                "The list is empty, nothing to remove"
            );
        } else if (index == size) {
            // can't remove a node at the index == size cause it won't already be on thel list (with add we can cause this is what AddInTail() do)
            throw new IndexOutOfBoundsException(
                "index: " + index + "size: " + size
            );
        }

        if (index == 0) removeHead();
        else if (index == size - 1) removeTail();

        Node<T> trav1;
        Node<T> trav2;
        int trav2Index;

        if (index <= (size - 1) / 2) {
            trav1 = head;
            trav2 = trav1.next;
            trav2Index = 1;

            while (trav2Index != index) {
                trav1 = trav1.next;
                trav2 = trav2.next;
                trav2Index++;
            }

            Node<T> temp = trav2;
            trav2 = trav2.next;
            trav1.next = trav2;
            trav2.previous = trav1;
            size--;
            return temp;
        } else {
            trav1 = tail;
            trav2 = tail.previous;
            trav2Index = size - 1;

            while (trav2Index != index) {
                trav1 = trav1.previous;
                trav2 = trav2.previous;
                trav2Index--;
            }

            Node<T> temp = trav2;
            trav2 = trav2.previous;
            trav1.previous = trav2;
            trav2.next = trav1;
            size--;
            return temp;
        }
    }

    public Node<T> getHead() {
        if (isEmpty()) {
            throw new Error("the list is empty, cannot get the head");
        }

        return head;
    }

    public Node<T> getTail() {
        if (isEmpty()) {
            throw new Error("the list is empty, cannot get the tail");
        }

        return tail;
    }

    public Node<T> getAtIndex(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException(
                "the list is empty, cannot get any Node"
            );
        } else if (index == 0) {
            getHead();
        } else if (index == size - 1) {
            getTail();
        }

        Node<T> trav;
        int travIndex;

        // do the math, it's right, like for size 4 (0,1,2,3) and index = 2; this is 2 <= 3/2 => 2 <= 1.5 => (rounded to the floor by default) 2 <= 1 (false so the other {right cause is nearer to tail than head})
        if (index <= (size - 1) / 2) {
            trav = head;
            travIndex = 0;

            while (travIndex != index) {
                trav = trav.next;
                travIndex++;
            }

            return trav;
        } else {
            trav = tail;
            travIndex = size - 1;

            while (travIndex != index) {
                trav = trav.previous;
                travIndex--;
            }

            return trav;
        }
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
