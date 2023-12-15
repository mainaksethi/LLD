package repository;

import models.Driver;
import models.Location;
import models.Trip;

import java.util.HashMap;
import java.util.Map;

public class DriverRepository {

    private Map<String, Driver> driverMap = new HashMap<>();
    public void registerDriver(Driver driver) {
        // Assuming getting random md5 hash.
        driverMap.put(driver.getId(), driver);
    }

    public void updateLocation(Location location, String driver_id) {
        driverMap.get(driver_id).setCurrentLocation(location);
    }

    public void updateAvailaibility(boolean is_available, String driver_id) {
        driverMap.get(driver_id).setAvailable(is_available);
    }

    public Driver getNearestDriver(Location location) {
        Driver nearest_driver = null;
        for (Driver driver: driverMap.values()) {
            if (nearest_driver == null ||
                getDistance(driver.getCurrentLocation(), location) < getDistance(nearest_driver.getCurrentLocation(), location)) {
                nearest_driver = driver;
            }
        }
        return nearest_driver;
    }

    public double getDistance(Location from, Location to) {
        return Math.sqrt((from.getX()-to.getX())*(from.getX()-to.getX()) + (from.getY()-to.getY())*(from.getY()-to.getY()));
    }
}
