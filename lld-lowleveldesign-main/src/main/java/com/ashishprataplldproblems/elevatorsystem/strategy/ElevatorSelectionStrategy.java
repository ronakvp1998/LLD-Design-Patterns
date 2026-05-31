package com.ashishprataplldproblems.elevatorsystem.strategy;

import com.ashishprataplldproblems.elevatorsystem.Elevator;
import com.ashishprataplldproblems.elevatorsystem.models.Request;

import java.util.List;
import java.util.Optional;

public interface ElevatorSelectionStrategy {
    Optional<Elevator> selectElevator(List<Elevator> elevators, Request request);
}
