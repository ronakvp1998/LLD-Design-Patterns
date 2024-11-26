package com.LLD.Example.DesignParkingLot;

// Has-A
// 1 ParkingSpotManager

public class ParkingStrategy {

    ParkingSpotManager parkingSpotManager;

    // default strategy to find the 1st empty from the list
    public ParkingSpot find(){
        return parkingSpotManager.getParkingSpotList().stream().filter(s -> s.isEmpty).findFirst().get();
    }
}
