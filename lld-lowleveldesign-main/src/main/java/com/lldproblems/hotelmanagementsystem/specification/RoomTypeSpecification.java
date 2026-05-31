package com.lldproblems.hotelmanagementsystem.specification;

import com.lldproblems.hotelmanagementsystem.enums.RoomType;
import com.lldproblems.hotelmanagementsystem.model.Room;

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
