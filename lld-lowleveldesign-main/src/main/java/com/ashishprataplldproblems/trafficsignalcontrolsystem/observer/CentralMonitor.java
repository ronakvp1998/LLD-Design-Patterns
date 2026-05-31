package com.ashishprataplldproblems.trafficsignalcontrolsystem.observer;

import com.ashishprataplldproblems.trafficsignalcontrolsystem.enums.Direction;
import com.ashishprataplldproblems.trafficsignalcontrolsystem.enums.LightColor;

public class CentralMonitor implements TrafficObserver {
    @Override
    public void update(int intersectionId, Direction direction, LightColor color) {
        System.out.printf("[MONITOR] Intersection %d: Light for %s direction changed to %s.\n",
                intersectionId, direction, color);
    }
}
