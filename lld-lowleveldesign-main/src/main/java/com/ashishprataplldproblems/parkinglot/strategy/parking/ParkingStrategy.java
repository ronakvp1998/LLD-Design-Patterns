package com.ashishprataplldproblems.parkinglot.strategy.parking;

import com.ashishprataplldproblems.parkinglot.entities.ParkingFloor;
import com.ashishprataplldproblems.parkinglot.entities.ParkingSpot;
import com.ashishprataplldproblems.parkinglot.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
