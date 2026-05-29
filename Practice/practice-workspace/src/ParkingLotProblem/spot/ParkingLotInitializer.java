package ParkingLotProblem.spot;

import ParkingLotProblem.vehicle.VehicleSize;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ParkingLotInitializer {
    public static Map<VehicleSize, List<ParkingSpot>> createDefaultSpots(){
        Map<VehicleSize,List<ParkingSpot>> availableSpots = new ConcurrentHashMap<>();

        availableSpots.put(VehicleSize.SMALL,new CopyOnWriteArrayList<>());
        availableSpots.put(VehicleSize.MEDIUM,new CopyOnWriteArrayList<>());
        availableSpots.put(VehicleSize.LARGE,new CopyOnWriteArrayList<>());

        availableSpots.get(VehicleSize.SMALL).add(new CompactSpot(1,3));
        availableSpots.get(VehicleSize.SMALL).add(new CompactSpot(2,3));
        availableSpots.get(VehicleSize.SMALL).add(new CompactSpot(3,3));
        availableSpots.get(VehicleSize.SMALL).add(new CompactSpot(4,3));

        availableSpots.get(VehicleSize.MEDIUM).add(new RegularSpot(1,2));
        availableSpots.get(VehicleSize.MEDIUM).add(new RegularSpot(2,2));
        availableSpots.get(VehicleSize.MEDIUM).add(new RegularSpot(3,2));
        availableSpots.get(VehicleSize.MEDIUM).add(new RegularSpot(4,2));

        availableSpots.get(VehicleSize.LARGE).add(new LargeSpot(1,1));
        availableSpots.get(VehicleSize.LARGE).add(new LargeSpot(2,1));
        availableSpots.get(VehicleSize.LARGE).add(new LargeSpot(3,1));
        availableSpots.get(VehicleSize.LARGE).add(new LargeSpot(4,1));

        return availableSpots;
     }
}
