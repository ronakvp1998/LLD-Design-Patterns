package com.ashishprataplldproblems.medium.hotelmanagementsystem.factory;

import com.ashishprataplldproblems.medium.hotelmanagementsystem.enums.RoomStyle;
import com.ashishprataplldproblems.medium.hotelmanagementsystem.enums.RoomType;
import com.ashishprataplldproblems.medium.hotelmanagementsystem.model.Room;

public class RoomFactory {
    public static Room createRoom(String roomNumber, String type, String style, double price) {
        RoomType roomType = RoomType.valueOf(type.toUpperCase());
        RoomStyle roomStyle = RoomStyle.valueOf(style.toUpperCase());
        return new Room(roomNumber, roomType, roomStyle, price);
    }
}
