package com.LLD.LLDProblems.DesignParkingLot;

import java.util.List;

// has-A
// 1 ParkingSpot

// Is-A
// 1 ParkingSpotManager

public class TwoWheelerSpotManager extends ParkingSpotManager{

    // this is the list of all 2 wheeler parking spot
    List<ParkingSpot> parkingSpotList ;


    TwoWheelerSpotManager(List<ParkingSpot> parkingSpotList,ParkingStrategy ps) {
        super(parkingSpotList, ps);
    }
}
