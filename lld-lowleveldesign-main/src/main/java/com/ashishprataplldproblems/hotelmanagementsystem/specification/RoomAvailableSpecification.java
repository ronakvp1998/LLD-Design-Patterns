package com.ashishprataplldproblems.hotelmanagementsystem.specification;

import com.ashishprataplldproblems.hotelmanagementsystem.model.Room;
import com.ashishprataplldproblems.hotelmanagementsystem.state.AvailableState;

public class RoomAvailableSpecification extends AbstractSpecification<Room> {
    @Override
    public boolean isSatisfiedBy(Room item) {
        return item.getState() instanceof AvailableState;
    }
}
