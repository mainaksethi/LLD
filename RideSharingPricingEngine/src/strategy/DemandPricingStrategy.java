package strategy;

import models.Ride;

public class DemandPricingStrategy implements PricingStrategy {

    private static DemandPricingStrategy demandPricingStrategySingleton = new DemandPricingStrategy();

    @Override
    public int setPrice(Ride r) {
        return 0;
    }

    @Override
    public int getOrder() {
        return 100;
    }

    public static DemandPricingStrategy get_instance() {
        return demandPricingStrategySingleton;
    }
}
