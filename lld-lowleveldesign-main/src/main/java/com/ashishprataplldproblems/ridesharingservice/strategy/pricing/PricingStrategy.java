package com.ashishprataplldproblems.ridesharingservice.strategy.pricing;

import com.ashishprataplldproblems.ridesharingservice.entities.Location;
import com.ashishprataplldproblems.ridesharingservice.enums.RideType;

public interface PricingStrategy {
    double calculateFare(Location pickup, Location dropoff, RideType rideType);
}
