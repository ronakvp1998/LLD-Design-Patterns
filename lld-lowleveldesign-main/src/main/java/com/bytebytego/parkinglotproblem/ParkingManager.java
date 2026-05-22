package com.bytebytego.parkinglotproblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {

    private final Map<VehicleSize, List<ParkingSpot>> availableSpots;
    private final Map<Vehicle,ParkingSpot> vehicletoSpotMap;

    public ParkingManager(Map<VehicleSize, List<ParkingSpot>> availableSpot){
        this.availableSpots = availableSpot;
        this.vehicletoSpotMap = new HashMap<>();
    }

    public ParkingSpot findSpotForVehicle(Vehicle vehicle){
        VehicleSize vehicleSize = vehicle.getSize();

        // start looking for the smallest sport that can fit the vehicle
        for(VehicleSize size : VehicleSize.values()){
            if(size.ordinal() >= vehicleSize.ordinal()){
                List<ParkingSpot> spots = availableSpots.get(size);
                for(ParkingSpot spot : spots){
                    if(spot.isAvailable()){
                        return spot; // Return the first available spot
                    }
                }
            }
        }
        return null; // No suitable spot found
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot spot = findSpotForVehicle(vehicle);
        if(spot != null){
            spot.occupy(vehicle);
            // Record the parking spot for the vehicle
            vehicletoSpotMap.put(vehicle,spot);
            // Remove the spot from the available list
            availableSpots.get(spot.getSize()).remove(spot);
            return spot;
        }
        return null;  // no spot found for this vehicle
    }

    public void unparkVehicle(Vehicle vehicle){
        ParkingSpot spot = vehicletoSpotMap.remove(vehicle);
        if(spot != null){
            spot.vacate();
            availableSpots.get(spot.getSize()).add(spot);
        }
    }


}
