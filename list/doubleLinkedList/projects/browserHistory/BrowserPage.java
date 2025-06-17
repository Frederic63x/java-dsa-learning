import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;

public final class BrowserPage {

    public final String name;
    public final String url; // also for this a Url class
    // implementing later... public final String ipAddress; // also class IpAddress
    public LocalDateTime lastVisit;
    public int numberOfVisits; // just increase it when usign the re-visit, cause even with the same url the user could choose a differenct name, it's really to rare for a test to check if the name and url are equal to some in thel list, but i could try;

    public BrowserPage(String name, String url) {
        this.name = name;
        // this.ipAddress = ipAddress;
        this.url = url;
        this.lastVisit = LocalDateTime.now();
        this.numberOfVisits = 1;
    }

    @Override
    public String toString() {
        return ("name: " + name + " url: " + url + " lastVisit: " + lastVisit);
    }
}
