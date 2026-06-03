package com.ashishprataplldproblems.medium.elevatorsystem.strategy;

import com.ashishprataplldproblems.medium.elevatorsystem.Elevator;
import com.ashishprataplldproblems.medium.elevatorsystem.models.Request;

import java.util.List;
import java.util.Optional;

public interface ElevatorSelectionStrategy {
    Optional<Elevator> selectElevator(List<Elevator> elevators, Request request);
}
