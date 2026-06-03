package com.ashishprataplldproblems.easy.trafficsignalcontrolsystem.observer;

import com.ashishprataplldproblems.easy.trafficsignalcontrolsystem.enums.Direction;
import com.ashishprataplldproblems.easy.trafficsignalcontrolsystem.enums.LightColor;

public interface TrafficObserver {
    void update(int intersectionId, Direction direction, LightColor color);
}
