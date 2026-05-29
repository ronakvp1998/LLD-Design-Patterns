package com.bytebytego.parkinglotproblem.spot;

import com.bytebytego.parkinglotproblem.vehicle.Vehicle;
import com.bytebytego.parkinglotproblem.vehicle.VehicleSize;

public interface ParkingSpot {
    boolean isAvailable();
    void occupy(Vehicle vehicle) ;
    void vacate();
    int getSpotNumber();
    int getFloor();
    VehicleSize getSize();
}
