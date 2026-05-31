package com.ashishprataplldproblems.ridesharingservice.strategy.matching;

import java.util.List;

import com.ashishprataplldproblems.ridesharingservice.entities.Driver;
import com.ashishprataplldproblems.ridesharingservice.entities.Location;
import com.ashishprataplldproblems.ridesharingservice.enums.RideType;

public interface DriverMatchingStrategy {
    List<Driver> findDrivers(List<Driver> allDrivers, Location pickupLocation, RideType rideType);
}
