package com.ashishprataplldproblems.trafficsignalcontrolsystem.states.light;

import com.ashishprataplldproblems.trafficsignalcontrolsystem.TrafficLight;

public interface SignalState {
    void handle(TrafficLight context);
}
