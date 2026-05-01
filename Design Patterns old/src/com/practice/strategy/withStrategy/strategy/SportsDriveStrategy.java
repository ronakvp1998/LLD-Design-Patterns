package com.practice.strategy.withStrategy.strategy;

public class SportsDriveStrategy implements DriveStrategy{


    @Override
    public void drive() {
        System.out.println("Sports drive capability");
    }
}
