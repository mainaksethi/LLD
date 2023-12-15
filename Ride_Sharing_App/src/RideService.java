import models.Driver;
import models.Location;
import models.Rider;
import models.Trip;
import repository.DriverRepository;
import repository.RiderRepository;
import repository.TripRepository;
import strategy.BookingStrategy;

import java.util.List;

public class RideService {

    private BookingStrategy bookingStrategy;
    private DriverRepository driverRepository;
    private RiderRepository riderRepository;
    private TripRepository tripRepository;

    public RideService(BookingStrategy bookingStrategy, DriverRepository driverRepository, RiderRepository riderRepository, TripRepository tripRepository) {
        this.bookingStrategy = bookingStrategy;
        this.driverRepository = driverRepository;
        this.riderRepository = riderRepository;
        this.tripRepository = tripRepository;
    }

    public void registerRider(Rider rider) {
        riderRepository.registerRider(rider);
    }

    public void registerDriver(Driver driver) {
        driverRepository.registerDriver(driver);
    }

    public void updateLocationOfDriver(Location location, String driver_id) {
        driverRepository.updateLocation(location, driver_id);
    }

    public void updateAvailaibility(boolean is_available, String driver_id) {
        driverRepository.updateAvailaibility(is_available, driver_id);
    }

    public void bookCab(String rider_id) {
        Rider rider = riderRepository.getRider(rider_id);
        Driver driver = bookingStrategy.getBestCab(rider, driverRepository);
        Trip trip = tripRepository.createTrip(driver, rider);
        riderRepository.addTrip(rider, trip);
    }

    public List<Trip> getTripHistory(String rider_id) {
        return riderRepository.getTripHistory(rider_id);
    }

    public void endTrip(String trip_id) {
        tripRepository.endTrip(trip_id);
    }
}
