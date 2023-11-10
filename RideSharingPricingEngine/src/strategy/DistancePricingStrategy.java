package strategy;

import models.Ride;

public class DistancePricingStrategy implements PricingStrategy {

    private static DistancePricingStrategy distancePricingStrategy = new DistancePricingStrategy();

    @Override
    public int setPrice(Ride r) {
        return 0;
    }

    @Override
    public int getOrder() {
        return 1;
    }

    public static DistancePricingStrategy get_instance() {
        return distancePricingStrategy;
    }

}
