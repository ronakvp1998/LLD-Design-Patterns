package com.LLD.DesignPattern.Strategy.WitStrategyPattern.Strategy;

public class SportsDriveStrategy implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("Sports drive capability");
    }
}
