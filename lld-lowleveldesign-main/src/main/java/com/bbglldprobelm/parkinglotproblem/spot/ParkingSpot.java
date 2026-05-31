package com.bbglldprobelm.parkinglotproblem.spot;

import com.bbglldprobelm.parkinglotproblem.vehicle.Vehicle;
import com.bbglldprobelm.parkinglotproblem.vehicle.VehicleSize;

public interface ParkingSpot {
    boolean isAvailable();
    void occupy(Vehicle vehicle) ;
    void vacate();
    int getSpotNumber();
    int getFloor();
    VehicleSize getSize();
}
