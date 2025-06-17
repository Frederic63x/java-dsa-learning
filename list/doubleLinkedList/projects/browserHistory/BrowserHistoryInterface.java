public interface BrowserHistoryInterface {
    public int numberOfPageInHistory = 0;
    public final DoubleLinkedList<BrowserPage> browserHistory =
        new DoubleLinkedList<BrowserPage>();

    public void visitNewPage(String name, String url);

    public void revisitPage(int index);

    // return the page removed
    public BrowserPage removeAPage(int index);

    //remove a number of page
    public BrowserPage[] removePages(int indexes[]);

    // return the number of elimined page
    public int removeAllPages();

    public void printHistory();
}
