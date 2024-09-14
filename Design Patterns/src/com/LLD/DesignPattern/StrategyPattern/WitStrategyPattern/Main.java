package com.LLD.DesignPattern.StrategyPattern.WitStrategyPattern;

public class Main {

    public static void main(String[] args) {
        Vehicle vehicle1 = new SportsVehicle();
//        Sports drive capability
        vehicle1.drive();

        Vehicle vehicle2 = new GoodsVehicle();
//        normal drive capability
        vehicle2.drive();

        Vehicle vehicle3 = new OffRoadVehicle();
//        Sports drive capability
        vehicle3.drive();

    }
}
