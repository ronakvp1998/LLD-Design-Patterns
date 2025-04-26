package com.LLD.LLDProblems.DesignParkingLot;

// Has-A
// 1 Vehicle
// 2 ParkingSpot

public class Ticket {

    long entryTime;
    Vehicle vehicle;
    ParkingSpot parkingSpot;

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
