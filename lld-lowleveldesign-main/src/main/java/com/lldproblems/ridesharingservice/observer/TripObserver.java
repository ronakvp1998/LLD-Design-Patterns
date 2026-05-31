package com.lldproblems.ridesharingservice.observer;

import com.lldproblems.ridesharingservice.entities.Trip;

public interface TripObserver {
    void onUpdate(Trip trip);
}
