package com.ashishprataplldproblems.medium.elevatorsystem.observer;

import com.ashishprataplldproblems.medium.elevatorsystem.Elevator;

public class ElevatorDisplay implements ElevatorObserver {
    @Override
    public void update(Elevator elevator) {
        System.out.println("[DISPLAY] Elevator " + elevator.getId() +
                " | Current Floor: " + elevator.getCurrentFloor() +
                " | Direction: " + elevator.getDirection());
    }
}
