package com.ashishprataplldproblems.hotelmanagementsystem.state;

import com.ashishprataplldproblems.hotelmanagementsystem.model.Room;

public interface RoomState {
    void book(Room room);
    void checkIn(Room room);
    void checkOut(Room room);
    void markForMaintenance(Room room);
}
