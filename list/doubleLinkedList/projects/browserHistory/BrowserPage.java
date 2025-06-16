import java.time.LocalDateTime;

public final class BrowserPage {

    public final String name;
    public final String url; // also for this a Url class
    // implementing later... public final String ipAddress; // also class IpAddress
    public LocalDateTime lastVisit;

    public BrowserPage(String name, String url) {
        this.name = name;
        // this.ipAddress = ipAddress;
        this.url = url;
        this.lastVisit = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return ("name: " + name + " ipAddress: " + " lastVisit: " + lastVisit);
    }
}
