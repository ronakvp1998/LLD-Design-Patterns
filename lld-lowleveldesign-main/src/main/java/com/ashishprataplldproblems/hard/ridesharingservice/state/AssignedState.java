package com.ashishprataplldproblems.hard.ridesharingservice.state;

import com.ashishprataplldproblems.hard.ridesharingservice.entities.Driver;
import com.ashishprataplldproblems.hard.ridesharingservice.entities.Trip;
import com.ashishprataplldproblems.hard.ridesharingservice.enums.TripStatus;

public class AssignedState implements TripState {
    @Override
    public void request(Trip trip) {
        System.out.println("Trip has already been requested and assigned.");
    }

    @Override
    public void assign(Trip trip, Driver driver) {
        System.out.println("Trip is already assigned. To re-assign, cancel first.");
    }

    @Override
    public void start(Trip trip) {
        trip.setStatus(TripStatus.IN_PROGRESS);
        trip.setState(new InProgressState());
    }

    @Override
    public void end(Trip trip) {
        System.out.println("Cannot end a trip that has not started.");
    }
}
