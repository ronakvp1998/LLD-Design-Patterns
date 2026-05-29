package com.practice.parkinglotproblem;

public class BaseFareCalculator implements FareStrategy{


    @Override
    public long calculateFare(Ticket ticket) {
        return (ticket.exitTime.getMinute() - ticket.entrytime.getMinute()) * 100;
    }
}
