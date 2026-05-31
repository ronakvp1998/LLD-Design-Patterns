package com.lldproblems.ridesharingservice.state;

import com.lldproblems.ridesharingservice.entities.Driver;
import com.lldproblems.ridesharingservice.entities.Trip;

public interface TripState {
    void request(Trip trip);
    void assign(Trip trip, Driver driver);
    void start(Trip trip);
    void end(Trip trip);
}
