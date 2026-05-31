package com.lldproblems.stackoverflow.observer;

import com.lldproblems.stackoverflow.entities.Event;

public interface PostObserver {
    void onPostEvent(Event event);
}
