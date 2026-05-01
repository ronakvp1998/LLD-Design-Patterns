package com.LLD.DesignPattern.StrategyPattern.WitStrategyPattern;

import com.LLD.DesignPattern.StrategyPattern.WitStrategyPattern.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{

    GoodsVehicle(){
        super(new NormalDriveStrategy());
    }
}
