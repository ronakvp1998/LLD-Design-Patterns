package com.LLD.DesignPattern.Strategy.WitStrategyPattern;

import com.LLD.DesignPattern.Strategy.WitStrategyPattern.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle{

    OffRoadVehicle(){
        super(new SportsDriveStrategy());
    }
}
