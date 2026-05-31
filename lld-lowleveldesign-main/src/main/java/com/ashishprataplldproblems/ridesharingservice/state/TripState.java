package com.ashishprataplldproblems.ridesharingservice.state;

import com.ashishprataplldproblems.ridesharingservice.entities.Driver;
import com.ashishprataplldproblems.ridesharingservice.entities.Trip;

public interface TripState {
    void request(Trip trip);
    void assign(Trip trip, Driver driver);
    void start(Trip trip);
    void end(Trip trip);
}
