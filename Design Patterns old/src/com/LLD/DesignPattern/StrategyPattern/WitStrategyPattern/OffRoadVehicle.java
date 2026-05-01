package com.LLD.DesignPattern.StrategyPattern.WitStrategyPattern;

import com.LLD.DesignPattern.StrategyPattern.WitStrategyPattern.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle{

    OffRoadVehicle(){
        super(new SportsDriveStrategy());
    }
}
