package com.LLD.Example.DesignParkingLot;

import java.util.List;

// Has-A
// 1 ParkingSpotManager

// factory patten implemented
public class ParkingSpotManagerFactory {

    public ParkingSpotManager getParkingSpotManager(Vehicle vehicle
    , List<ParkingSpot> parkingSpotList, ParkingStrategy parkingStrategy){
        if(vehicle.vehicleType == VehicleType.TwoWheeler){
            return new TwoWheelerSpotManager(parkingSpotList,parkingStrategy);
        } else if (vehicle.vehicleType == VehicleType.FourWheeler) {
            return new FourWheelerSpotManager(parkingSpotList,parkingStrategy);
        }

        return null;
    }
}
