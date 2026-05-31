package com.lldproblems.hotelmanagementsystem.state;

import com.lldproblems.hotelmanagementsystem.model.Room;

public interface RoomState {
    void book(Room room);
    void checkIn(Room room);
    void checkOut(Room room);
    void markForMaintenance(Room room);
}
