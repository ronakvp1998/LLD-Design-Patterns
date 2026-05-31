package com.ashishprataplldproblems.movieticketbookingsystem.strategy.pricing;

import com.ashishprataplldproblems.movieticketbookingsystem.entities.Seat;

import java.util.List;

public class WeekdayPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(List<Seat> seats) {
        return seats.stream().mapToDouble(seat -> seat.getType().getPrice()).sum();
    }
}
