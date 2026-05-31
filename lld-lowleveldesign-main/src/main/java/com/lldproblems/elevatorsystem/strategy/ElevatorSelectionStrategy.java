package com.lldproblems.elevatorsystem.strategy;

import com.lldproblems.elevatorsystem.Elevator;
import com.lldproblems.elevatorsystem.models.Request;

import java.util.List;
import java.util.Optional;

public interface ElevatorSelectionStrategy {
    Optional<Elevator> selectElevator(List<Elevator> elevators, Request request);
}
