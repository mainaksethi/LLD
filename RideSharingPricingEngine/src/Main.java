import manager.PricingManager;
import models.Driver;
import models.Location;
import models.Ride;
import models.Rider;

public class Main {
    public static void main(String[] args) {
        Driver driver = new Driver("driver", 1L);
        Rider rider = new Rider("rider", "1");
        Location start = new Location("123");
        Location end = new Location("456");
        long unixTime = System.currentTimeMillis() / 1000L;
        Ride r = new Ride(driver, rider, start, end, unixTime, 0);
        PricingManager pricingManager = new PricingManager();
        pricingManager.setPrice(r);
    }
}