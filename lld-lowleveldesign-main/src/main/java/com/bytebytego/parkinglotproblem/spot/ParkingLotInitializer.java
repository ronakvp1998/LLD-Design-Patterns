package com.bytebytego.parkinglotproblem.spot;

import com.bytebytego.parkinglotproblem.vehicle.VehicleSize;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ParkingLotInitializer {

    public static Map<VehicleSize, List<ParkingSpot>> createDefaultSpots() {
        Map<VehicleSize, List<ParkingSpot>> availableSpots = new ConcurrentHashMap<>();
        availableSpots.put(VehicleSize.SMALL, new CopyOnWriteArrayList<>());
        availableSpots.put(VehicleSize.MEDIUM, new CopyOnWriteArrayList<>());
        availableSpots.put(VehicleSize.LARGE, new CopyOnWriteArrayList<>());

        availableSpots.get(VehicleSize.SMALL).add(new CompactSpot(1, 1));
        availableSpots.get(VehicleSize.SMALL).add(new CompactSpot(1, 2));
        availableSpots.get(VehicleSize.MEDIUM).add(new RegularSpot(1, 3));
        availableSpots.get(VehicleSize.MEDIUM).add(new RegularSpot(2, 4));
        availableSpots.get(VehicleSize.MEDIUM).add(new HandicappedSpot(2, 5));
        availableSpots.get(VehicleSize.MEDIUM).add(new HandicappedSpot(2, 6));
        availableSpots.get(VehicleSize.LARGE).add(new LargeSpot(1, 7));
        availableSpots.get(VehicleSize.LARGE).add(new LargeSpot(2, 8));

        return availableSpots;
    }
}
