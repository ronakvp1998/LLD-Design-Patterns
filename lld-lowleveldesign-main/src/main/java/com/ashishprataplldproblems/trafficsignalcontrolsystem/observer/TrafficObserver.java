package com.ashishprataplldproblems.trafficsignalcontrolsystem.observer;

import com.ashishprataplldproblems.trafficsignalcontrolsystem.enums.Direction;
import com.ashishprataplldproblems.trafficsignalcontrolsystem.enums.LightColor;

public interface TrafficObserver {
    void update(int intersectionId, Direction direction, LightColor color);
}
