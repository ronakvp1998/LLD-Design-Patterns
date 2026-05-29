package com.bytebytego.elevator_system.elevator.observer;

import elevator.components.Direction;

// Observer Interface
public interface ElevatorObserver {
    void update(int floor, Direction direction);
}
