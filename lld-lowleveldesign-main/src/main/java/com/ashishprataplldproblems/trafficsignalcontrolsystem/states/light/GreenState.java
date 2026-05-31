package com.ashishprataplldproblems.trafficsignalcontrolsystem.states.light;

import com.ashishprataplldproblems.trafficsignalcontrolsystem.TrafficLight;
import com.ashishprataplldproblems.trafficsignalcontrolsystem.enums.LightColor;

public class GreenState implements SignalState {
    @Override
    public void handle(TrafficLight context) {
        context.setColor(LightColor.GREEN);
        // After being green, the next state is yellow.
        context.setNextState(new YellowState());
    }
}
