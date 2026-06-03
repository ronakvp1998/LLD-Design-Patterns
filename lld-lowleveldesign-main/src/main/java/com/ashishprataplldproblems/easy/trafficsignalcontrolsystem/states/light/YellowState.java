package com.ashishprataplldproblems.easy.trafficsignalcontrolsystem.states.light;

import com.ashishprataplldproblems.easy.trafficsignalcontrolsystem.TrafficLight;
import com.ashishprataplldproblems.easy.trafficsignalcontrolsystem.enums.LightColor;

public class YellowState implements SignalState {
    @Override
    public void handle(TrafficLight context) {
        context.setColor(LightColor.YELLOW);
        // After being yellow, the next state is red.
        context.setNextState(new RedState());
    }
}
