package com.LLD.DesignPattern.StrategyPattern.WitStrategyPattern;

import com.LLD.DesignPattern.StrategyPattern.WitStrategyPattern.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {

    SportsVehicle(){
        super(new SportsDriveStrategy());
    }
}
