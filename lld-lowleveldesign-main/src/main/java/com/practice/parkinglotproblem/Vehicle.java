package com.practice.parkinglotproblem;

public class Vehicle {
    private final String licinse;
    private final VehicleSize size;

    public Vehicle(String licinse, VehicleSize size) {
        this.licinse = licinse;
        this.size = size;
    }

    public String getLicinse(){
        return licinse;
    }

    public VehicleSize getSize(){
        return size;
    }
}
