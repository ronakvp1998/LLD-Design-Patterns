package com.lldproblems.elevatorsystem.state;

import com.lldproblems.elevatorsystem.Elevator;
import com.lldproblems.elevatorsystem.enums.Direction;
import com.lldproblems.elevatorsystem.models.Request;

public interface ElevatorState {
    void move(Elevator elevator);
    void addRequest(Elevator elevator, Request request);
    Direction getDirection();
}
