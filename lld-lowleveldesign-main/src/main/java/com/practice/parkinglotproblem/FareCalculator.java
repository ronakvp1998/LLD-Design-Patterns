package com.practice.parkinglotproblem;

public class FareCalculator {

    public long calculateFare(FareStrategy fareStrategy,Ticket ticket){
        return fareStrategy.calculateFare(ticket);
    }

}
