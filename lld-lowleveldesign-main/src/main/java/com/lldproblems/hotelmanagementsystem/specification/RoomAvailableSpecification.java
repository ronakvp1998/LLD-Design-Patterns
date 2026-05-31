package com.lldproblems.hotelmanagementsystem.specification;

import com.lldproblems.hotelmanagementsystem.model.Room;
import com.lldproblems.hotelmanagementsystem.state.AvailableState;

public class RoomAvailableSpecification extends AbstractSpecification<Room> {
    @Override
    public boolean isSatisfiedBy(Room item) {
        return item.getState() instanceof AvailableState;
    }
}
