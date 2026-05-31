package com.ashishprataplldproblems.parkinglot.strategy.fee;

import com.ashishprataplldproblems.parkinglot.entities.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket parkingTicket);
}
