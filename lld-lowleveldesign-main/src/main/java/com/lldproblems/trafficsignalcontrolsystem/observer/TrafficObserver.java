package com.lldproblems.trafficsignalcontrolsystem.observer;

import com.lldproblems.trafficsignalcontrolsystem.enums.Direction;
import com.lldproblems.trafficsignalcontrolsystem.enums.LightColor;

public interface TrafficObserver {
    void update(int intersectionId, Direction direction, LightColor color);
}
