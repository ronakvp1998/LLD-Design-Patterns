package com.bytebytego.parkinglotproblem.vehicle;

public enum VehicleSize {
    SMALL(1),
    MEDIUM(2),
    LARGE(3);

    private final int weight;

    VehicleSize(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
