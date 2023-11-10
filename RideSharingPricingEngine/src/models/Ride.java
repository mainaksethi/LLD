package models;

import java.sql.Time;

public class Ride {
    private Driver driver;
    private Rider rider;
    private Location from_location;
    private Location to_location;
    private Long booking_time;
    private int price;


    public Ride(Driver driver, Rider rider, Location from_location, Location to_location, Long booking_Long, int price) {
        this.driver = driver;
        this.rider = rider;
        this.from_location = from_location;
        this.to_location = to_location;
        this.booking_time = booking_Long;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Location getFrom_location() {
        return from_location;
    }

    public void setFrom_location(Location from_location) {
        this.from_location = from_location;
    }

    public Location getTo_location() {
        return to_location;
    }

    public void setTo_location(Location to_location) {
        this.to_location = to_location;
    }

    public Long getBooking_time() {
        return booking_time;
    }

    public void setBooking_time(Long booking_time) {
        this.booking_time = booking_time;
    }
}
