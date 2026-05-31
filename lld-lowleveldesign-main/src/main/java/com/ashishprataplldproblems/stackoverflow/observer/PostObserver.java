package com.ashishprataplldproblems.stackoverflow.observer;

import com.ashishprataplldproblems.stackoverflow.entities.Event;

public interface PostObserver {
    void onPostEvent(Event event);
}
