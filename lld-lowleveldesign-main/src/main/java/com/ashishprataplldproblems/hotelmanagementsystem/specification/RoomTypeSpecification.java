package com.ashishprataplldproblems.hotelmanagementsystem.specification;

import com.ashishprataplldproblems.hotelmanagementsystem.enums.RoomType;
import com.ashishprataplldproblems.hotelmanagementsystem.model.Room;

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
