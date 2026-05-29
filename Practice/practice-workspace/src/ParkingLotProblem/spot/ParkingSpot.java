package ParkingLotProblem.spot;

import ParkingLotProblem.vehicle.Vehicle;
import ParkingLotProblem.vehicle.VehicleSize;

public interface ParkingSpot {
    boolean isAvailable();
    void occupy(Vehicle vehicle);
    void vacate();
    int getSpotNumber();
    int getFloor();
    VehicleSize getSize();
}
