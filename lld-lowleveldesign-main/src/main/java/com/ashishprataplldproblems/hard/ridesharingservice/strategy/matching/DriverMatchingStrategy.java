package com.ashishprataplldproblems.hard.ridesharingservice.strategy.matching;

import java.util.List;

import com.ashishprataplldproblems.hard.ridesharingservice.entities.Driver;
import com.ashishprataplldproblems.hard.ridesharingservice.entities.Location;
import com.ashishprataplldproblems.hard.ridesharingservice.enums.RideType;

public interface DriverMatchingStrategy {
    List<Driver> findDrivers(List<Driver> allDrivers, Location pickupLocation, RideType rideType);
}
