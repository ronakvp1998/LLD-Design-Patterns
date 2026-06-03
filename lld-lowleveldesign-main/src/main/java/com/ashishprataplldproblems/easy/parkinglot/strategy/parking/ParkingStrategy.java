package com.ashishprataplldproblems.easy.parkinglot.strategy.parking;

import com.ashishprataplldproblems.easy.parkinglot.entities.ParkingFloor;
import com.ashishprataplldproblems.easy.parkinglot.entities.ParkingSpot;
import com.ashishprataplldproblems.easy.parkinglot.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
