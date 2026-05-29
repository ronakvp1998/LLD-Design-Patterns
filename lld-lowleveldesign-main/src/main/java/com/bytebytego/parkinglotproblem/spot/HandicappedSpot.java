package com.bytebytego.parkinglotproblem.spot;


import com.bytebytego.parkinglotproblem.vehicle.Vehicle;
import com.bytebytego.parkinglotproblem.vehicle.VehicleSize;

public class HandicappedSpot implements ParkingSpot {
    private int spotNumber;
    private int floor;
    private Vehicle vehicle;

    public HandicappedSpot(int floor, int spotNumber) {
        this.floor = floor;
        this.spotNumber = spotNumber;
        this.vehicle = null;
    }

    @Override
    public int getSpotNumber() {
        return spotNumber;
    }

    @Override
    public int getFloor() {
        return floor;
    }

    @Override
    public boolean isAvailable() {
        return vehicle == null;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if (isAvailable()) {
            this.vehicle = vehicle;
        } else {
            throw new IllegalStateException("Spot is already occupied");
        }
    }

    @Override
    public void vacate() {
        this.vehicle = null;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.MEDIUM;
    }
}