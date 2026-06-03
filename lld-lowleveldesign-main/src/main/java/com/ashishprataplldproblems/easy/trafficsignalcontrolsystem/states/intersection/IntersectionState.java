package com.ashishprataplldproblems.easy.trafficsignalcontrolsystem.states.intersection;

import com.ashishprataplldproblems.easy.trafficsignalcontrolsystem.IntersectionController;

public interface IntersectionState {
    void handle(IntersectionController context) throws InterruptedException;
}
