package ParkingLotProblem.spot;

import ParkingLotProblem.vehicle.Vehicle;
import ParkingLotProblem.vehicle.VehicleFactory;
import ParkingLotProblem.vehicle.VehicleSize;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingManager {
    private final Map<VehicleSize, List<ParkingSpot>> availableSpots;
    private final Map<Vehicle,ParkingSpot> vehicleParkingSpotMap;
    private final Lock lock = new ReentrantLock();

    public ParkingManager(Map<VehicleSize, List<ParkingSpot>> availableSpots) {
        this.availableSpots = availableSpots;
        this.vehicleParkingSpotMap = new ConcurrentHashMap<>();
    }

    public ParkingSpot findSpotForVehicle(Vehicle vehicle){
        lock.lock();
        try {
            VehicleSize vehicleSize = vehicle.getSize();
            for(VehicleSize size : VehicleSize.values()){
                if(size.ordinal() >= vehicleSize.ordinal()){
                    List<ParkingSpot> spots = availableSpots.get(size);
                    if(spots != null){
                        for(ParkingSpot spot : spots){
                            if(spot.isAvailable()){
                                return spot;
                            }
                        }
                    }
                }
            }
            return null;
        }finally {
            lock.unlock();
        }
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        lock.lock();
        try {
            if(vehicleParkingSpotMap.containsKey(vehicle)){
                throw new IllegalStateException("Vehicle is already parked");
            }
            ParkingSpot spot = findSpotForVehicle(vehicle);
            if(spot != null){
                spot.occupy(vehicle);
                vehicleParkingSpotMap.put(vehicle,spot);
                availableSpots.get(spot.getSize()).remove(spot);
                return spot;
            }
            return null;
        }finally {
            lock.unlock();
        }
    }

    public void unparkVehicle(Vehicle vehicle){
        lock.lock();
        try {
            ParkingSpot spot = vehicleParkingSpotMap.remove(vehicle);
            if(spot != null){
                spot.vacate();
                availableSpots.get(spot.getSize()).add(spot);
            }
        }finally {
            lock.unlock();
        }
    }

}
