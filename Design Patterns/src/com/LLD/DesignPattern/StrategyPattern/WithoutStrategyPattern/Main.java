package com.LLD.DesignPattern.StrategyPattern.WithoutStrategyPattern;



public class Main {

    public static void main(String[] args) {
        Vehicle vehicle1 = new SportsVehicle();
//        Sports drive capability
        vehicle1.drive();

        Vehicle vehicle2 = new GoodsVehicle();
//        Normal drive capability
        vehicle2.drive();

        Vehicle vehicle3 = new OffRoadVehicle();
//        Sports drive capability
        vehicle3.drive();

        Vehicle vehicle4 = new PassengerVehicle();
//        Normal drive capability
        vehicle4.drive();

        // GoodVehicle & PassengerVehicle => Normal drive capability
        // SportsVehicle & OffRoadVehicle => Sports drive capability
        // there is code duplication in the child classes

    }
}
