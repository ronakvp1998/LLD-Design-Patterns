package com.ashishprataplldproblems.medium.airlinemanagementsystem.booking;

import com.ashishprataplldproblems.medium.airlinemanagementsystem.flight.Flight;
import com.ashishprataplldproblems.medium.airlinemanagementsystem.Passenger;
import com.ashishprataplldproblems.medium.airlinemanagementsystem.seat.Seat;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BookingManager {
    private static BookingManager instance;
    private final Map<String, Booking> bookings;
    private final Object lock = new Object();

    private BookingManager() {
        bookings = new HashMap<>();
    }

    public static synchronized BookingManager getInstance() {
        if (instance == null) {
            instance = new BookingManager();
        }
        return instance;
    }

    public Booking createBooking(Flight flight, Passenger passenger, Seat seat, double price) {
        String bookingNumber = UUID.randomUUID().toString();
        Booking booking = new Booking(flight, passenger, seat, price);
        synchronized (lock) {
            bookings.put(bookingNumber, booking);
        }
        return booking;
    }

    public void cancelBooking(String bookingNumber) {
        synchronized (lock) {
            Booking booking = bookings.get(bookingNumber);
            if (booking != null) {
                booking.cancel();
            }
        }
    }
}
