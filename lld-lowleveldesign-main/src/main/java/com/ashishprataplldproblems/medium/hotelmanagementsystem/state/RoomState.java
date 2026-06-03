package com.ashishprataplldproblems.medium.hotelmanagementsystem.state;

import com.ashishprataplldproblems.medium.hotelmanagementsystem.model.Room;

public interface RoomState {
    void book(Room room);
    void checkIn(Room room);
    void checkOut(Room room);
    void markForMaintenance(Room room);
}
