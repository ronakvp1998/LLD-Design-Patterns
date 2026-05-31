package com.lldproblems.parkinglotproblem.fare;

import java.math.BigDecimal;
import java.util.List;

public class FareCalculator {
    private final List<FareStrategy> fareStrategies;

    public FareCalculator(List<FareStrategy> fareStrategies) {
        this.fareStrategies = fareStrategies;
    }

    // this implementation uses a list of strategies to build up the fare step-by-step. 
    // Each strategy takes the current fare calculated so far, 
    // modifies it based on its own rules, 
    // and passes the updated value to the next strategy in the list.
    public BigDecimal calculateFare(Ticket ticket){
        BigDecimal fare = BigDecimal.ZERO;
        for(FareStrategy strategy : fareStrategies){
            fare = strategy.calculateFare(ticket,fare);
        }
        return fare;
    }
}
