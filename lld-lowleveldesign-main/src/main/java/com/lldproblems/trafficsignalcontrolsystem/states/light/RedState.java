package com.lldproblems.trafficsignalcontrolsystem.states.light;

import com.lldproblems.trafficsignalcontrolsystem.TrafficLight;
import com.lldproblems.trafficsignalcontrolsystem.enums.LightColor;

public class RedState implements SignalState {
    @Override
    public void handle(TrafficLight context) {
        context.setColor(LightColor.RED);
        // Red is a stable state, it transitions to green only when the intersection controller commands it.
        // So, the next state is self.
        context.setNextState(new RedState());
    }
}
