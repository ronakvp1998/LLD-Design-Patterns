package com.lldproblems.trafficsignalcontrolsystem.states.intersection;

import com.lldproblems.trafficsignalcontrolsystem.IntersectionController;

public interface IntersectionState {
    void handle(IntersectionController context) throws InterruptedException;
}
