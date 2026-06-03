package com.ashishprataplldproblems.medium.hotelmanagementsystem.specification;

import com.ashishprataplldproblems.medium.hotelmanagementsystem.enums.RoomType;
import com.ashishprataplldproblems.medium.hotelmanagementsystem.model.Room;

public class RoomTypeSpecification extends AbstractSpecification<Room> {
    private final RoomType type;

    public RoomTypeSpecification(RoomType type) {
        this.type = type;
    }

    @Override
    public boolean isSatisfiedBy(Room item) {
        return item.getType() == type;
    }
}
