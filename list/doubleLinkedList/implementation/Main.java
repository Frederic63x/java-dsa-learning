import java.util.LinkedList;
import javax.print.Doc;

public class Main {

    public static void main(String[] args) {
        // LinkedList<Integer> l1 = new LinkedList<Integer>();
        System.out.println("start");

        DoubleLinkedList<Integer> l1 = new DoubleLinkedList<Integer>();

        Node<Integer> n1 = new Node<Integer>(10);
        Node<Integer> n2 = new Node<Integer>(20);
        Node<Integer> n3 = new Node<Integer>(30);
        Node<Integer> n4 = new Node<Integer>(40);

        l1.addInHead(n1);
        System.out.println("head: " + l1.head + " tail: " + l1.tail);
        l1.addInHead(n2);
        System.out.println("head: " + l1.head + " tail: " + l1.tail);
        l1.addInTail(n3);
        System.out.println("head: " + l1.head + " tail: " + l1.tail);
        l1.addAtIndex(2, n4);
        System.out.println("head: " + l1.head + " tail: " + l1.tail);

        l1.printList();
        System.out.println("end");
    }
}
