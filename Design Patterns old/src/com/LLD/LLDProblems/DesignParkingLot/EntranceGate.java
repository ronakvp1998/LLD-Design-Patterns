package com.LLD.LLDProblems.DesignParkingLot;

import java.util.List;

public class EntranceGate {

    ParkingSpotManagerFactory parkingSpotManagerFactory;

    public ParkingSpotManager findspace(Vehicle vehicle,
                                        List<ParkingSpot> parkingSpotList,
                                        ParkingStrategy parkingStrategy){
            return parkingSpotManagerFactory.getParkingSpotManager(vehicle,parkingSpotList,parkingStrategy);
    }

    public void bookspot(Vehicle vehicle,
                         List<ParkingSpot> parkingSpotList,
                         ParkingStrategy parkingStrategy){
        findspace(vehicle,parkingSpotList,parkingStrategy).parkVehicle(vehicle);
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot){

        return null;
    }

}
