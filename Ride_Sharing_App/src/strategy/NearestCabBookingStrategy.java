package strategy;

import models.Driver;
import models.Rider;
import repository.DriverRepository;

public class NearestCabBookingStrategy implements BookingStrategy {



    @Override
    public Driver getBestCab(Rider rider, DriverRepository driverRepository) {
        return driverRepository.getNearestDriver(rider.getLocation());
    }
}
