package manager;

import factory.PricingStrategyFactory;
import models.Ride;
import strategy.PricingStrategy;
import strategy.PricingStrategyType;

import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class PricingManager {

    private Set<PricingStrategy> pricingStrategySet;

    public Ride setPrice(Ride r) {
        List<PricingStrategy> pricingStrategySortedList = getSortedList(pricingStrategySet);
        for (PricingStrategy p: pricingStrategySortedList) {
            p.setPrice(r);
        }
        return r;
    }

    private List<PricingStrategy> getSortedList(Set<PricingStrategy> pricingStrategySet) {
        TreeMap<Integer, PricingStrategy> ordered_map = new TreeMap<>();
        for (PricingStrategy p: pricingStrategySet) {
            ordered_map.put(p.getOrder(), p);
        }
        return (List<PricingStrategy>) ordered_map.values();
    }


    public void registerStrategy(PricingStrategyType type) {
        PricingStrategy pricingStrategy = PricingStrategyFactory.getStrategy(type);
        pricingStrategySet.add(pricingStrategy);
    }

    public void removeStrategy(PricingStrategyType type) {
        PricingStrategy pricingStrategy = PricingStrategyFactory.getStrategy(type);
        pricingStrategySet.remove(pricingStrategy);
    }

}

