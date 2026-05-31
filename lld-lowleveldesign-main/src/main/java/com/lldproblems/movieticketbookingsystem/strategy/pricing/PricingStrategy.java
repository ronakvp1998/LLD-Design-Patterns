package com.lldproblems.movieticketbookingsystem.strategy.pricing;

import com.lldproblems.movieticketbookingsystem.entities.Seat;

import java.util.List;

public interface PricingStrategy {
    double calculatePrice(List<Seat> seats);
}
