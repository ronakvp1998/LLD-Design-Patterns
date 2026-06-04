package com.conceptcoding.behavioralpatterns.state.trafficlight;

public class YellowState implements TrafficLightState{

    @Override
    public void action(TrafficLight signal) {
        System.out.println("Yellow signal");
        signal.setState(new RedState());
    }
}
