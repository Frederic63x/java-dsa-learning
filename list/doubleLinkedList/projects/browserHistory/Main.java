public class Main {

    public static void main(String[] args) {
        DoubleLinkedList<BrowserPage> browserHistory = new DoubleLinkedList<
            BrowserPage
        >();
        BrowserPage p1 = new BrowserPage(
            "LinkedList explaination in Java",
            "https://www.youtube.com/watch?v=-Yn5DU0_-lw&list=PLDV1Zeh2NRsB6SWUrDFW2RmDotAfPbeHu&index=6"
        );
        Node<BrowserPage> n1 = new Node<BrowserPage>(p1);
        browserHistory.addAtIndex(0, n1);
        browserHistory.printList();
    }
}
