package com.LLD.Example.ParkingLot;

import java.util.List;

// Has-A
// 1 list -> Parking Spot

// Is-A
// 1 ParkingSpotManager

public class FourWheelerSpotManager extends ParkingSpotManager{

    // this is the list of all 4 wheeler parking spot
    List<ParkingSpot> parkingSpotList ;


    FourWheelerSpotManager(List<ParkingSpot> parkingSpotList,ParkingStrategy ps) {

        super(parkingSpotList,ps);
    }
}
