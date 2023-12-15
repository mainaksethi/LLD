package repository;

import models.Rider;
import models.Trip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RiderRepository {

    Map<String, Rider> riderMap = new HashMap<>();
    Map<String, List<Trip>> tripHistory = new HashMap<>();
    public void registerRider(Rider rider) {
        riderMap.put(rider.getId(), rider);
    }

    public Rider getRider(String rider_id) {
        return riderMap.get(rider_id);
    }

    public void addTrip(Rider rider, Trip trip) {
        List<Trip> trips = tripHistory.get(rider.getId());
        if (trips == null) {
            trips = new ArrayList<>();
        }
        trips.add(trip);
    }

    public List<Trip> getTripHistory(String rider_id) {
        return tripHistory.get(rider_id);
    }
}
