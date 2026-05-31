package com.ashishprataplldproblems.cricinfo.observer;

import com.ashishprataplldproblems.cricinfo.entity.Match;
import com.ashishprataplldproblems.cricinfo.entity.Ball;

public interface MatchObserver {
    void update(Match match, Ball lastBall);
}
