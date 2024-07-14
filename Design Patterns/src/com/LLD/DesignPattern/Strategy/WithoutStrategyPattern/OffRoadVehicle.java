package com.LLD.DesignPattern.Strategy.WithoutStrategyPattern;

public class OffRoadVehicle extends Vehicle{

    // code duplicate in sports and offroad Vehicle class
    public void drive(){
        System.out.println("Sports drive capability");
    }
}
