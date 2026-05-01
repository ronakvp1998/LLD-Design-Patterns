package com.practice.strategy.withStrategy;

import com.practice.strategy.withStrategy.strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle{

    OffRoadVehicle(){
        super(new SportsDriveStrategy());
    }
}
