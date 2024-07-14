package com.LLD.DesignPattern.Strategy.WitStrategyPattern;

import com.LLD.DesignPattern.Strategy.WitStrategyPattern.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{

    GoodsVehicle(){
        super(new NormalDriveStrategy());
    }
}
