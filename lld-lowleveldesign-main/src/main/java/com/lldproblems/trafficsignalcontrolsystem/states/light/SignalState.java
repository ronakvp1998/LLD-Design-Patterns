package com.lldproblems.trafficsignalcontrolsystem.states.light;

import com.lldproblems.trafficsignalcontrolsystem.TrafficLight;

public interface SignalState {
    void handle(TrafficLight context);
}
