package com.practice.strategy.withStrategy;

import com.practice.strategy.withStrategy.strategy.NormalDriveStrategy;

public class GoodVehicle extends Vehicle{

    GoodVehicle(){
        super(new NormalDriveStrategy());
    }
}
