package com.ashishprataplldproblems.elevatorsystem.state;

import com.ashishprataplldproblems.elevatorsystem.Elevator;
import com.ashishprataplldproblems.elevatorsystem.enums.Direction;
import com.ashishprataplldproblems.elevatorsystem.models.Request;

public interface ElevatorState {
    void move(Elevator elevator);
    void addRequest(Elevator elevator, Request request);
    Direction getDirection();
}
