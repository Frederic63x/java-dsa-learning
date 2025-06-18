import java.util.Scanner;

// BrowserPage p1 = new BrowserPage(
//     "LinkedList explaination in Java",
//     "https://www.youtube.com/watch?v=-Yn5DU0_-lw&list=PLDV1Zeh2NRsB6SWUrDFW2RmDotAfPbeHu&index=6"
// );
public class Main {

    public static void main(String[] args) {
        BrowserHistory history1 = new BrowserHistory();
        Scanner sc = new Scanner(System.in);
        askOperation(sc, history1);
        // System.out.print("What's your name? ");
        // String name = sc.nextLine();

        // System.out.printf("So %s. How old are you? ", name);
        // int age = sc.nextInt();

        // System.out.printf(
        //     "Cool! %d is a good age to start programming. \nWhat language would you prefer? ",
        //     age
        // );
        // String language = sc.nextLine();

        // System.out.printf("Ah! %s is a solid programming language.", language);
    }

    public static void askOperation(Scanner sc, BrowserHistory browserHistory) {
        int choosenOperation;
        while (true) {
            System.out.println(
                "Possible Operation:\n" +
                "0: exit the program\n" +
                "1: visit a site with the url.\n" +
                "2: revisit one of the last five visited page\n" +
                "3: show the current Browser History\n" +
                "4: delete a page from the history\n" +
                "5: delete multiple page from the history\n" +
                "6: delete all the pages history"
            );
            try {
                choosenOperation = Integer.parseInt(sc.nextLine());
                switch (choosenOperation) {
                    case 0:
                        System.out.println("program terminated");
                        return;
                    case 1:
                        handleVisitPage(sc, browserHistory);
                        // askOperatdion(sc, browserHistory);
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
            } catch (Exception e) {
                System.out.println(
                    "problem encountered in the execution of the program: " + e
                );
            }
        }
    }

    public static void handleVisitPage(
        Scanner sc,
        BrowserHistory browserHistory
    ) {
        // this is very bad cause it could be called not onlya sc.nextInt, so it's better the approach to do Integer.parseInt(sc.nextLine()) above
        // String scannerNewLineCleaner = sc.nextLine();

        System.out.print("insert it's name");
        String name = sc.nextLine();

        System.out.print("insert the url of the page to visit");
        String url = sc.nextLine();

        browserHistory.visitNewPage(name, url);
        System.out.println(browserHistory.getNumberOfPageInHistory());
        browserHistory.printHistory();
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
