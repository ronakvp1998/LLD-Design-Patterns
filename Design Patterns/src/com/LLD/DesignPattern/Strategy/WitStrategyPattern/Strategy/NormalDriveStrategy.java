package com.LLD.DesignPattern.Strategy.WitStrategyPattern.Strategy;

public class NormalDriveStrategy implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("normal drive capability");
    }
}
