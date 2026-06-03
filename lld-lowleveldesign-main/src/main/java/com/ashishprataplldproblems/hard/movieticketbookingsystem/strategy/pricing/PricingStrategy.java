package com.ashishprataplldproblems.hard.movieticketbookingsystem.strategy.pricing;

import com.ashishprataplldproblems.hard.movieticketbookingsystem.entities.Seat;

import java.util.List;

public interface PricingStrategy {
    double calculatePrice(List<Seat> seats);
}
