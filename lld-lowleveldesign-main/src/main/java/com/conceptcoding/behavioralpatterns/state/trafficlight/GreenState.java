package com.conceptcoding.behavioralpatterns.state.trafficlight;

public class GreenState implements TrafficLightState{

    @Override
    public void action(TrafficLight signal) {
        System.out.println("Green signal");
        signal.setState(new YellowState());
    }
}
