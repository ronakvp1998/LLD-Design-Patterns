package com.LLD.DesignPattern.StrategyPattern.WitStrategyPattern;

import com.LLD.DesignPattern.StrategyPattern.WitStrategyPattern.Strategy.DriveStrategy;

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
