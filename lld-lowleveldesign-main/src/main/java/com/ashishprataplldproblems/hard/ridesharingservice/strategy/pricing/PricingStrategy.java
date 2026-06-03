package com.ashishprataplldproblems.hard.ridesharingservice.strategy.pricing;

import com.ashishprataplldproblems.hard.ridesharingservice.entities.Location;
import com.ashishprataplldproblems.hard.ridesharingservice.enums.RideType;

public interface PricingStrategy {
    double calculateFare(Location pickup, Location dropoff, RideType rideType);
}
