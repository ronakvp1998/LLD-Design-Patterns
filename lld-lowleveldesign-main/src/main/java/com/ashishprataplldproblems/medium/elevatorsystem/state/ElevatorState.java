package com.ashishprataplldproblems.medium.elevatorsystem.state;

import com.ashishprataplldproblems.medium.elevatorsystem.Elevator;
import com.ashishprataplldproblems.medium.elevatorsystem.enums.Direction;
import com.ashishprataplldproblems.medium.elevatorsystem.models.Request;

public interface ElevatorState {
    void move(Elevator elevator);
    void addRequest(Elevator elevator, Request request);
    Direction getDirection();
}
