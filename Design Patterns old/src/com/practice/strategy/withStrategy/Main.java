package com.practice.strategy.withStrategy;

public class Main {
    public static void main(String[] args){

        Vehicle vehicle1 = new SportsVehicle();
        vehicle1.drive();

        Vehicle vehicle2 = new OffRoadVehicle();
        vehicle2.drive();

        Vehicle vehicle3 = new GoodVehicle();
        vehicle3.drive();

    }
}
