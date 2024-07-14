package com.LLD.DesignPattern.Strategy.WitStrategyPattern.Strategy;

public class XYZDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("XYZ drive capability");
    }
}
