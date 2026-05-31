package com.lldproblems.ridesharingservice.strategy.pricing;

import com.lldproblems.ridesharingservice.entities.Location;
import com.lldproblems.ridesharingservice.enums.RideType;

public interface PricingStrategy {
    double calculateFare(Location pickup, Location dropoff, RideType rideType);
}
