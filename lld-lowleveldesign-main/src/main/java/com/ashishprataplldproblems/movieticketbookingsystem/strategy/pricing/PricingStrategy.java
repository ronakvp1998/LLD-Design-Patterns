package com.ashishprataplldproblems.movieticketbookingsystem.strategy.pricing;

import com.ashishprataplldproblems.movieticketbookingsystem.entities.Seat;

import java.util.List;

public interface PricingStrategy {
    double calculatePrice(List<Seat> seats);
}
