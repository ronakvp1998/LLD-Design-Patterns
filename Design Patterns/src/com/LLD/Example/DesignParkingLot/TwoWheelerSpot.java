package com.LLD.Example.DesignParkingLot;

// Is-A
// 1 ParkingSpot

public class TwoWheelerSpot extends ParkingSpot{

    @Override
    public int price(){
        return 10;
    }
}
