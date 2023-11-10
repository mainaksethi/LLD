package models;

public class Location {
    private String geoId;

    public Location(String geoId) {
        this.geoId = geoId;
    }

    public String getGeoId() {
        return geoId;
    }

    public void setGeoId(String geoId) {
        this.geoId = geoId;
    }
}
