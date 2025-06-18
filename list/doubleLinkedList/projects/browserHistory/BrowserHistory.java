public class BrowserHistory implements BrowserHistoryInterface {

    private final DoubleLinkedList<BrowserPage> browserHistory =
        new DoubleLinkedList<>();

    private int numberOfPageInHistory = browserHistory.size;

    public void visitNewPage(String name, String url) {
        BrowserPage newPage = new BrowserPage(name, url);
        Node<BrowserPage> newNode = new Node<BrowserPage>(newPage);
        browserHistory.addInTail(newNode); // when i should not use addInTail? for the browserHistory is the only possible thing i think.
        numberOfPageInHistory++;
    }

    // @params index: is the index choosen by the user via console of the Node<BrowserPage> inside the brwoserHistory DoubleLinkedList<BrowserPage>
    public void revisitPage(int index) {
        Node<BrowserPage> reVisitedPage = browserHistory.getAtIndex(index);
        browserHistory.addInTail(reVisitedPage);
        numberOfPageInHistory++;
    }

    public Node<BrowserPage> getPageByIndex(int index) {
        return browserHistory.getAtIndex(index);
    }

    public void printHistory() {
        browserHistory.printList();
    }

    public int getNumberOfPageInHistory() {
        return numberOfPageInHistory;
    }

    public BrowserPage removeAPage(int index) {
        numberOfPageInHistory--;
        return new BrowserPage("", "");
    }

    public BrowserPage[] removePages(int[] indexes) {
        // just for test
        BrowserPage[] eliminatedPages = { new BrowserPage("", "") };
        numberOfPageInHistory -= indexes.length; // or just = to browserHistory.size just know wich is better
        return eliminatedPages;
    }

    public int removeAllPages() {
        numberOfPageInHistory = 0;
        return 0;
    }
}
