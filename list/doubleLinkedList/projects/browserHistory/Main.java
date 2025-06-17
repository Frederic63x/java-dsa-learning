import java.util.Scanner;

// BrowserPage p1 = new BrowserPage(
//     "LinkedList explaination in Java",
//     "https://www.youtube.com/watch?v=-Yn5DU0_-lw&list=PLDV1Zeh2NRsB6SWUrDFW2RmDotAfPbeHu&index=6"
// );
public class Main {

    public static void main(String[] args) {
        BrowserHistory history1 = new BrowserHistory();

        Scanner sc = new Scanner(System.in);
        System.out.println("pippo");

        System.out.println("pippo");
        sc.nextLine();
        sc.close();
    }

    public static void askOperation(Scanner sc, BrowserHistory browserHistory) {
        System.out.println(
            "Possible Operation:\n" +
            "0: exit the program" +
            "1: visit a site with the url.\n" +
            "2: revisit one of the last five visited page\n" +
            "3: show the current Browser History\n" +
            "4: delete a page from the history\n" +
            "5: delete multiple page from the history\n" +
            "6:  delete all the pages history"
        );
        int choosenOperation;
        do {
            choosenOperation = sc.nextInt();
            switch (choosenOperation) {
                case 0:
                    System.out.println("program terminated");
                    break;
                case 1:
                    handleVisitPage(sc, browserHistory);
                    break;
                case 2:
                    handleRevisitLastFive(sc, browserHistory);
                    break;
                case 3:
                    browserHistory.printHistory();
                    break;
                default:
                    System.out.println("function not yet implemented");
            }
        } while (
            choosenOperation != 0 ||
            choosenOperation != 1 ||
            choosenOperation != 2 ||
            choosenOperation != 3
        );
        sc.close();
    }

    public static void handleVisitPage(
        Scanner sc,
        BrowserHistory browserHistory
    ) {
        System.out.println(browserHistory.getNumberOfPageInHistory());

        System.out.println("insert the url of the page to visit");
        String url = sc.nextLine();

        System.out.println("insert it's name");
        String name = sc.nextLine();
        sc.close();
        browserHistory.visitNewPage(name, url);
    }

    public static void handleRevisitLastFive(
        Scanner sc,
        BrowserHistory browserHistory
    ) {
        int size = browserHistory.getNumberOfPageInHistory();
        Node<BrowserPage> tempNode;
        for (int i = size - 1; i > size - 6; i++) {
            tempNode = browserHistory.getPageByIndex(i);
            System.out.println(tempNode);
        }
        int choosenIndex;
        do {
            System.out.println(
                "insert the index of the page you want to revisit below, the first (0) is the latest. if you don't want to continue insert 5"
            );
            choosenIndex = sc.nextInt();
        } while (choosenIndex < 0 || choosenIndex > 5); // check if he can also write double/float and if yes i should use != for every option
        sc.close();
        browserHistory.revisitPage(choosenIndex);
        System.out.println(
            "sucefully revisited page: " +
            browserHistory.getPageByIndex(choosenIndex)
        );
    }
}
