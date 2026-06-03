package com.ashishprataplldproblems.medium.hotelmanagementsystem.specification;

import com.ashishprataplldproblems.medium.hotelmanagementsystem.enums.RoomStyle;
import com.ashishprataplldproblems.medium.hotelmanagementsystem.model.Room;

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
