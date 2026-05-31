package com.lldproblems.parkinglotproblem.spot;


import com.lldproblems.parkinglotproblem.vehicle.Vehicle;
import com.lldproblems.parkinglotproblem.vehicle.VehicleSize;

public class RegularSpot implements ParkingSpot {
    private int spotNumber;
    private int floor;
    private Vehicle vehicle;  // The vehicle currently occupying this spot

    public RegularSpot(int floor, int spotNumber) {
        this.floor = floor;
        this.spotNumber = spotNumber;
        this.vehicle = null;  // No vehicle occupying initially
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
        return vehicle == null;  // Available if no vehicle is occupying
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
        this.vehicle = null;  // Make the spot available
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.MEDIUM;  // Regular spots fit medium vehicles
    }
}