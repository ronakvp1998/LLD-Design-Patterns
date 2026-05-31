package com.lldproblems.cricinfo.observer;

import com.lldproblems.cricinfo.entity.Match;
import com.lldproblems.cricinfo.entity.Ball;

public interface MatchObserver {
    void update(Match match, Ball lastBall);
}
