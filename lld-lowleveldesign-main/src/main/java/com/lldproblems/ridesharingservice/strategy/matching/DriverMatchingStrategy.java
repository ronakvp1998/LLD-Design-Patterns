package com.lldproblems.ridesharingservice.strategy.matching;

import java.util.List;

import com.lldproblems.ridesharingservice.entities.Driver;
import com.lldproblems.ridesharingservice.entities.Location;
import com.lldproblems.ridesharingservice.enums.RideType;

public interface DriverMatchingStrategy {
    List<Driver> findDrivers(List<Driver> allDrivers, Location pickupLocation, RideType rideType);
}
