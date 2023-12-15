package repository;

import models.Driver;
import models.Rider;
import models.Status;
import models.Trip;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class TripRepository {

    private Map<String, Trip> tripMap;
    public Trip createTrip(Driver driver, Rider rider) {
        String id = ThreadLocalRandom.current().toString();
        Trip trip = new Trip(id, rider, driver, Status.Created);
        tripMap.put(id, trip);
        return trip;
    }

    public void endTrip(String trip_id) {
        Trip trip = tripMap.get(trip_id);
        trip.setStatus(Status.Completed);
    }
}
