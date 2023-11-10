package factory;

import exception.PricingStrategyException;
import strategy.*;

public class PricingStrategyFactory {

    public static PricingStrategy getStrategy(PricingStrategyType type) {
        switch (type) {
            case DEMAND_PRICING_STRATEGY:
                return DemandPricingStrategy.get_instance();
            case DISTANCE_PRICING_STRATEGY:
                return DistancePricingStrategy.get_instance();
            case TIME_SURGE_PRICING_STRATEGY:
                return TimeSurgePricingStrategy.get_instance();
            default:
                throw new PricingStrategyException("Pricing Strategy Invalid");
        }
    }
}
