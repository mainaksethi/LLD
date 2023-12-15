package models;

public class Trip {

    private String id;
    private Rider rider;
    private Driver driver;
    private Status status;

    public Trip(String id, Rider rider, Driver driver, Status status) {
        this.id = id;
        this.rider = rider;
        this.driver = driver;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
