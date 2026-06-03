package com.ashishprataplldproblems.easy.parkinglot.strategy.fee;

import com.ashishprataplldproblems.easy.parkinglot.entities.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket parkingTicket);
}
