package com.ashishprataplldproblems.medium.hotelmanagementsystem.specification;

import com.ashishprataplldproblems.medium.hotelmanagementsystem.model.Room;
import com.ashishprataplldproblems.medium.hotelmanagementsystem.state.AvailableState;

public class RoomAvailableSpecification extends AbstractSpecification<Room> {
    @Override
    public boolean isSatisfiedBy(Room item) {
        return item.getState() instanceof AvailableState;
    }
}
