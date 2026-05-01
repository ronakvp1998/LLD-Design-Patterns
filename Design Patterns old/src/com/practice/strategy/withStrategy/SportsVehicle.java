package com.practice.strategy.withStrategy;


import com.practice.strategy.withStrategy.Vehicle;
import com.practice.strategy.withStrategy.strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {

    SportsVehicle(){
        super(new SportsDriveStrategy());
    }
}
