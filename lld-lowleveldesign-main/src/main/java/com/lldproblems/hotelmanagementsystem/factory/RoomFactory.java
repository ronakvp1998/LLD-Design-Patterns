package com.lldproblems.hotelmanagementsystem.factory;

import com.lldproblems.hotelmanagementsystem.enums.RoomStyle;
import com.lldproblems.hotelmanagementsystem.enums.RoomType;
import com.lldproblems.hotelmanagementsystem.model.Room;

public class RoomFactory {
    public static Room createRoom(String roomNumber, String type, String style, double price) {
        RoomType roomType = RoomType.valueOf(type.toUpperCase());
        RoomStyle roomStyle = RoomStyle.valueOf(style.toUpperCase());
        return new Room(roomNumber, roomType, roomStyle, price);
    }
}
