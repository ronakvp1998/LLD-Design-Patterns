package com.LLD.Example.ParkingLot;

import java.util.List;
// has - A
// 1 list -> Parking Spot
// 2 Parking Strategy

public class ParkingSpotManager {

    List<ParkingSpot> parkingSpotList ;
    ParkingStrategy ps;

    ParkingSpotManager(List<ParkingSpot> parkingSpotList, ParkingStrategy ps) {
        this.parkingSpotList = parkingSpotList;
        this.ps = ps;
    }

    // This is default & strategy implementation to find the parking spot
    // return the 1st empty parking spot
    public ParkingSpot findParkingSpace(){

        if(ps instanceof NearToEntranceStrategy || ps instanceof NearToEntranceAndElevatorStrategy){
            ps.find();
        }
            return parkingSpotList.stream().filter(s -> s.isEmpty).findFirst().get();
    }

    public void addParkingSpace(){

    }

    public void removeParkingSpace(){

    }

    public void parkVehicle(Vehicle vehicle){

        ParkingSpot spot = findParkingSpace();
        spot.isEmpty = false;
        spot.vehicle = vehicle;

        // calculate price

        parkingSpotList.add(spot);

    }

    public void removeVehicle(){

    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }
}
