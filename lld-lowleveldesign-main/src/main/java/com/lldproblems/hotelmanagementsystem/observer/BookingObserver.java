package com.lldproblems.hotelmanagementsystem.observer;

import com.lldproblems.hotelmanagementsystem.model.Booking;

public interface BookingObserver {
    void update(Booking booking);
}
