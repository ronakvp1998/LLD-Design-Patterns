package com.ashishprataplldproblems.hard.ridesharingservice.observer;

import com.ashishprataplldproblems.hard.ridesharingservice.entities.Trip;

public interface TripObserver {
    void onUpdate(Trip trip);
}
