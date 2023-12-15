package strategy;

import models.Driver;
import models.Rider;
import repository.DriverRepository;

public interface BookingStrategy {
    public Driver getBestCab(Rider rider, DriverRepository driverRepository);
}
