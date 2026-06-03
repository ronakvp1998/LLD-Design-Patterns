package com.ashishprataplldproblems.easy.trafficsignalcontrolsystem.states.light;

import com.ashishprataplldproblems.easy.trafficsignalcontrolsystem.TrafficLight;
import com.ashishprataplldproblems.easy.trafficsignalcontrolsystem.enums.LightColor;

public class GreenState implements SignalState {
    @Override
    public void handle(TrafficLight context) {
        context.setColor(LightColor.GREEN);
        // After being green, the next state is yellow.
        context.setNextState(new YellowState());
    }
}
