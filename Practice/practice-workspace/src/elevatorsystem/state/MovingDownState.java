package elevatorsystem.state;

import elevatorsystem.Elevator;
import elevatorsystem.enums.Direction;
import elevatorsystem.models.Request;

public class MovingDownState implements ElevatorState{
    @Override
    public void move(Elevator elevator) {

    }

    @Override
    public void addRequest(Elevator elevator, Request request) {

    }

    @Override
    public Direction getDirection() {
        return null;
    }
}
