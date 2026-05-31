package com.lldproblems.hotelmanagementsystem.specification;

import com.lldproblems.hotelmanagementsystem.enums.RoomStyle;
import com.lldproblems.hotelmanagementsystem.model.Room;

public class RoomStyleSpecification extends AbstractSpecification<Room> {
    private final RoomStyle style;

    public RoomStyleSpecification(RoomStyle style) {
        this.style = style;
    }

    @Override
    public boolean isSatisfiedBy(Room item) {
        return item.getStyle() == style;
    }
}
