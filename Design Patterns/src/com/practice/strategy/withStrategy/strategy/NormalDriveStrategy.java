package com.practice.strategy.withStrategy.strategy;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Normal drive capability");
    }
}
