package com.lldproblems.parkinglot.strategy.parking;

import com.lldproblems.parkinglot.entities.ParkingFloor;
import com.lldproblems.parkinglot.entities.ParkingSpot;
import com.lldproblems.parkinglot.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
