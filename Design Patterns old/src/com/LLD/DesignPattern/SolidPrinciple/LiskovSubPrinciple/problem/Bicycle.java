package com.LLD.DesignPattern.SolidPrinciple.LiskovSubPrinciple.problem;

public class Bicycle implements Bike{


    @Override
    public void turnOnEngine() {
        // problem : narrowing the property of parent
        throw new AssertionError("there is no engine");
    }

    @Override
    public void accelerate() {

    }
}
