package com.lldproblems.parkinglot.strategy.fee;

import com.lldproblems.parkinglot.entities.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket parkingTicket);
}
