package strategy;

import models.Ride;

public interface PricingStrategy {
    public int setPrice(Ride r);

    public int getOrder();

}
