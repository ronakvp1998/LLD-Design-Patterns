package com.ashishprataplldproblems.hard.ridesharingservice.state;

import com.ashishprataplldproblems.hard.ridesharingservice.entities.Driver;
import com.ashishprataplldproblems.hard.ridesharingservice.entities.Trip;

public interface TripState {
    void request(Trip trip);
    void assign(Trip trip, Driver driver);
    void start(Trip trip);
    void end(Trip trip);
}
