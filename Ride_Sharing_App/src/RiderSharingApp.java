import repository.DriverRepository;
import repository.RiderRepository;
import repository.TripRepository;
import strategy.NearestCabBookingStrategy;

public class RiderSharingApp {
    public static void main(String[] args) {
        RideService rideService = new RideService(
            new NearestCabBookingStrategy(),
            new DriverRepository(),
            new RiderRepository(),
            new TripRepository()
        );
    }
}