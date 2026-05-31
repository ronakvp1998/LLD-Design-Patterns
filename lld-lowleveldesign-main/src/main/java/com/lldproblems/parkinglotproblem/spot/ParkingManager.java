package com.lldproblems.parkinglotproblem.spot;

import com.lldproblems.parkinglotproblem.vehicle.Vehicle;
import com.lldproblems.parkinglotproblem.vehicle.VehicleSize;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingManager {

    private final Map<VehicleSize, List<ParkingSpot>> availableSpots;
    private final Map<Vehicle, ParkingSpot> vehicletoSpotMap;
    private final Lock lock = new ReentrantLock();

    public ParkingManager(Map<VehicleSize, List<ParkingSpot>> availableSpot){
        this.availableSpots = availableSpot;
        this.vehicletoSpotMap = new ConcurrentHashMap<>();
    }

    public ParkingSpot findSpotForVehicle(Vehicle vehicle){
        lock.lock();
        try {
            VehicleSize vehicleSize = vehicle.getSize();

            // start looking for the smallest sport that can fit the vehicle
            for(VehicleSize size : VehicleSize.values()){
                if(size.ordinal() >= vehicleSize.ordinal()){
                    List<ParkingSpot> spots = availableSpots.get(size);
                    if (spots != null) {
                        for(ParkingSpot spot : spots){
                            if(spot.isAvailable()){
                                return spot; // Return the first available spot
                            }
                        }
                    }
                }
            }
            return null; // No suitable spot found
        } finally {
            lock.unlock();
        }
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        lock.lock();
        try {
            if (vehicletoSpotMap.containsKey(vehicle)) {
                throw new IllegalStateException("Vehicle is already parked");
            }
            ParkingSpot spot = findSpotForVehicle(vehicle);
            if(spot != null){
                spot.occupy(vehicle);
                // Record the parking spot for the vehicle
                vehicletoSpotMap.put(vehicle, spot);
                // Remove the spot from the available list
                availableSpots.get(spot.getSize()).remove(spot);
                return spot;
            }
            return null;  // no spot found for this vehicle
        } finally {
            lock.unlock();
        }
    }

    public void unparkVehicle(Vehicle vehicle){
        lock.lock();
        try {
            ParkingSpot spot = vehicletoSpotMap.remove(vehicle);
            if(spot != null){
                spot.vacate();
                availableSpots.get(spot.getSize()).add(spot);
            }
        } finally {
            lock.unlock();
        }
    }

}
