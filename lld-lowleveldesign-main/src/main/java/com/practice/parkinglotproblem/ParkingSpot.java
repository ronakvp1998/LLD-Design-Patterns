package com.practice.parkinglotproblem;

public class ParkingSpot {

    boolean isAvailable;
    ParkingSpotSize spotSize;
    Vehicle vehicle;

    public boolean spotAvailable(){
        return isAvailable;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public void occupy(){
        isAvailable = false;
    }

    public void vacant(){
        isAvailable = true;
    }

}
