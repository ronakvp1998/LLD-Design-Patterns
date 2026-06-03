package com.ashishprataplldproblems.easy.trafficsignalcontrolsystem.states.light;

import com.ashishprataplldproblems.easy.trafficsignalcontrolsystem.TrafficLight;

public interface SignalState {
    void handle(TrafficLight context);
}
