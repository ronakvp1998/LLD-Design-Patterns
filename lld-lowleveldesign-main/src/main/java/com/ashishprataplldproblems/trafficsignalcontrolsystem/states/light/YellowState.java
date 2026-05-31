package com.ashishprataplldproblems.trafficsignalcontrolsystem.states.light;

import com.ashishprataplldproblems.trafficsignalcontrolsystem.TrafficLight;
import com.ashishprataplldproblems.trafficsignalcontrolsystem.enums.LightColor;

public class YellowState implements SignalState {
    @Override
    public void handle(TrafficLight context) {
        context.setColor(LightColor.YELLOW);
        // After being yellow, the next state is red.
        context.setNextState(new RedState());
    }
}
