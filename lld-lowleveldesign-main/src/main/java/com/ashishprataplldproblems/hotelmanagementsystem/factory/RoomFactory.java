package com.ashishprataplldproblems.hotelmanagementsystem.factory;

import com.ashishprataplldproblems.hotelmanagementsystem.enums.RoomStyle;
import com.ashishprataplldproblems.hotelmanagementsystem.enums.RoomType;
import com.ashishprataplldproblems.hotelmanagementsystem.model.Room;

public class RoomFactory {
    public static Room createRoom(String roomNumber, String type, String style, double price) {
        RoomType roomType = RoomType.valueOf(type.toUpperCase());
        RoomStyle roomStyle = RoomStyle.valueOf(style.toUpperCase());
        return new Room(roomNumber, roomType, roomStyle, price);
    }
}
