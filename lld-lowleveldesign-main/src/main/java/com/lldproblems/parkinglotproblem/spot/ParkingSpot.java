package com.lldproblems.parkinglotproblem.spot;

import com.lldproblems.parkinglotproblem.vehicle.Vehicle;
import com.lldproblems.parkinglotproblem.vehicle.VehicleSize;

public interface ParkingSpot {
    boolean isAvailable();
    void occupy(Vehicle vehicle) ;
    void vacate();
    int getSpotNumber();
    int getFloor();
    VehicleSize getSize();
}
