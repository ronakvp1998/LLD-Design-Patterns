package com.lldproblems.parkinglotproblem.spot;

import com.lldproblems.parkinglotproblem.vehicle.Vehicle;
import com.lldproblems.parkinglotproblem.vehicle.VehicleSize;

public class CompactSpot implements ParkingSpot{
    private int spotNumber;
    private int floor;
    private Vehicle vehicle;

    public CompactSpot(int floor, int spotNumber) {
        this.floor = floor;
        this.spotNumber = spotNumber;
        this.vehicle = null;
    }

    @Override
    public boolean isAvailable() {
        return vehicle == null;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if(isAvailable()){
            this.vehicle = vehicle;
        }else{
            throw new IllegalStateException("Spot is already occupied");
        }
    }

    @Override
    public void vacate() {
        this.vehicle = null;
    }

    @Override
    public int getSpotNumber() {
        return this.spotNumber;
    }

    @Override
    public int getFloor() {
        return this.floor;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.SMALL;
    }
}
