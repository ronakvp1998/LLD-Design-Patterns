package com.ashishprataplldproblems.ridesharingservice.observer;

import com.ashishprataplldproblems.ridesharingservice.entities.Trip;

public interface TripObserver {
    void onUpdate(Trip trip);
}
