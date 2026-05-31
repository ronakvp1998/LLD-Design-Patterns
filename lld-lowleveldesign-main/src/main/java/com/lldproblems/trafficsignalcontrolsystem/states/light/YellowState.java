package com.lldproblems.trafficsignalcontrolsystem.states.light;

import com.lldproblems.trafficsignalcontrolsystem.TrafficLight;
import com.lldproblems.trafficsignalcontrolsystem.enums.LightColor;

public class YellowState implements SignalState {
    @Override
    public void handle(TrafficLight context) {
        context.setColor(LightColor.YELLOW);
        // After being yellow, the next state is red.
        context.setNextState(new RedState());
    }
}
