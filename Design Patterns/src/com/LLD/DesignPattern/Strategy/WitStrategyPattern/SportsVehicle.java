package com.LLD.DesignPattern.Strategy.WitStrategyPattern;

import com.LLD.DesignPattern.Strategy.WitStrategyPattern.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {

    SportsVehicle(){
        super(new SportsDriveStrategy());
    }
}
