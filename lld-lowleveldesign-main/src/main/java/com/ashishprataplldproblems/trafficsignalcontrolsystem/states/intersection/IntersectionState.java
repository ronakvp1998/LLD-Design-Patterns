package com.ashishprataplldproblems.trafficsignalcontrolsystem.states.intersection;

import com.ashishprataplldproblems.trafficsignalcontrolsystem.IntersectionController;

public interface IntersectionState {
    void handle(IntersectionController context) throws InterruptedException;
}
