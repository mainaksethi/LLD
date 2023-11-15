// Follow up Questions which can be asked
// what if we change the distance api from google to bing distance how will we incorporate it.
// Ans: We will be using Adapter pattern for this.

public class Main {
    static class Location {
        private Integer geoPoint;

        public Location(Integer geoPoint) {
            this.geoPoint = geoPoint;
        }

        public Integer getGeoPoint() {
            return geoPoint;
        }

        public void setGeoPoint(Integer geoPoint) {
            this.geoPoint = geoPoint;
        }
    }
    static class Ride {

        private Long timestamp;
        private Location from;
        private Location to;

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public Location getFrom() {
            return from;
        }

        public void setFrom(Location from) {
            this.from = from;
        }

        public Location getTo() {
            return to;
        }

        public void setTo(Location to) {
            this.to = to;
        }

        public Integer getDistance() {
            return getTo().getGeoPoint() - getFrom().getGeoPoint();
        }

        public Ride(Long timestamp, Location from, Location to) {
            this.timestamp = timestamp;
            this.from = from;
            this.to = to;
        }
    }

    interface PricingStrategy {

        public Integer getPrice(Integer existingPrice);

    }

    static class DemandPricingStrategy implements PricingStrategy {

        private Integer demandMultiplier;
        private PricingStrategy nextPricingStrategy = null;
        public void setNextStrategy(PricingStrategy pricingStrategy) {
            this.nextPricingStrategy = pricingStrategy;
        }

        public DemandPricingStrategy(Integer demandMultiplier) {
            this.demandMultiplier = demandMultiplier;
        }
        @java.lang.Override
        public Integer getPrice(Integer existingPrice) {
            Integer currentPrice = (existingPrice*this.demandMultiplier);
            if (nextPricingStrategy != null) {
                currentPrice = nextPricingStrategy.getPrice(currentPrice);
            }
            return currentPrice;
        }
    }

    static class TimeOfDayPricingStrategy implements PricingStrategy {

        private Integer timeOfDayMultiplier;
        private PricingStrategy nextPricingStrategy = null;
        public void setNextStrategy(PricingStrategy pricingStrategy) {
            this.nextPricingStrategy = pricingStrategy;
        }

        private Ride ride;

        public TimeOfDayPricingStrategy(Integer timeOfDayMultiplier, Ride ride) {
            this.timeOfDayMultiplier = timeOfDayMultiplier;
            this.ride = ride;
        }

        @java.lang.Override
        public Integer getPrice(Integer existingPrice) {
            Integer currentPrice = (existingPrice + ride.getTimestamp().intValue() * this.timeOfDayMultiplier);
            if (nextPricingStrategy != null) {
                currentPrice = nextPricingStrategy.getPrice(currentPrice);
            }
            return currentPrice;
        }
    }

    static class DistancePricingStrategy implements PricingStrategy {

        private Integer distanceMultiplier;

        private Ride ride;
        private PricingStrategy nextPricingStrategy = null;
        public void setNextStrategy(PricingStrategy pricingStrategy) {
            this.nextPricingStrategy = pricingStrategy;
        }

        public DistancePricingStrategy(Integer distanceMultiplier, Ride ride) {
            this.distanceMultiplier = distanceMultiplier;
            this.ride = ride;
        }

        @java.lang.Override
        public Integer getPrice(Integer existingPrice) {
            Integer currentPrice = (existingPrice + ride.getDistance()*this.distanceMultiplier);
            if (nextPricingStrategy != null) {
                currentPrice = nextPricingStrategy.getPrice(currentPrice);
            }
            return currentPrice;
        }
    }


    static class BasePricingStrategy implements PricingStrategy {
        private Integer basePrice;
        private PricingStrategy nextPricingStrategy = null;
        public void setNextStrategy(PricingStrategy pricingStrategy) {
            this.nextPricingStrategy = pricingStrategy;
        }

        public BasePricingStrategy(Integer basePrice) {
            this.basePrice = basePrice;
        }

        @java.lang.Override
        public Integer getPrice(Integer existingPrice) {
            Integer currentPrice = (existingPrice + basePrice);
            if (nextPricingStrategy != null) {
                currentPrice = nextPricingStrategy.getPrice(currentPrice);
            }
            return currentPrice;
        }
    }

    public static void main(String[] args) {
        Ride ride = new Ride(1L, new Location(1), new Location(2));
        BasePricingStrategy basePricingStrategy = new BasePricingStrategy(100);
        DistancePricingStrategy distancePricingStrategy = new DistancePricingStrategy(2, ride);
        DemandPricingStrategy demandPricingStrategy = new DemandPricingStrategy(3);
        TimeOfDayPricingStrategy timeOfDayPricingStrategy = new TimeOfDayPricingStrategy(2, ride);
        basePricingStrategy.setNextStrategy(distancePricingStrategy);
        distancePricingStrategy.setNextStrategy(demandPricingStrategy);
        timeOfDayPricingStrategy.setNextStrategy(distancePricingStrategy);
        System.out.println(basePricingStrategy.getPrice(0));
    }
}