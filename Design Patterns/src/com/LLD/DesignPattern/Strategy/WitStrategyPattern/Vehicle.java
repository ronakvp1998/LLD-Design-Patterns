package com.LLD.DesignPattern.Strategy.WitStrategyPattern;

import com.LLD.DesignPattern.Strategy.WitStrategyPattern.Strategy.DriveStrategy;

public class Vehicle {

    DriveStrategy driveObject;

    // using constructor injection we will get Specific DriveStrategy
    Vehicle(DriveStrategy driveObject){
        this.driveObject = driveObject;
    }

    public void drive(){
        driveObject.drive();
    }
}
