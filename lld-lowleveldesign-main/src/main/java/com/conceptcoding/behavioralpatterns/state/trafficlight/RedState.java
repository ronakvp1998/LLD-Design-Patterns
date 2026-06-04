package com.conceptcoding.behavioralpatterns.state.trafficlight;

public class RedState implements TrafficLightState{

    @Override
    public void action(TrafficLight signal) {
        System.out.println("Red signal");
        signal.setState(new GreenState());
    }
}
