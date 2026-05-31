package com.lldproblems.trafficsignalcontrolsystem.states.light;

import com.lldproblems.trafficsignalcontrolsystem.TrafficLight;
import com.lldproblems.trafficsignalcontrolsystem.enums.LightColor;

public class GreenState implements SignalState {
    @Override
    public void handle(TrafficLight context) {
        context.setColor(LightColor.GREEN);
        // After being green, the next state is yellow.
        context.setNextState(new YellowState());
    }
}
