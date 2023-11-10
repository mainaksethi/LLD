package strategy;

import models.Ride;

public class TimeSurgePricingStrategy implements PricingStrategy {

    private static TimeSurgePricingStrategy timeSurgePricingStrategy = new TimeSurgePricingStrategy();

    @Override
    public int setPrice(Ride r) {
        return 0;
    }

    @Override
    public int getOrder() {
        return 10;
    }

    public static TimeSurgePricingStrategy get_instance() {
        return timeSurgePricingStrategy;
    }

}
