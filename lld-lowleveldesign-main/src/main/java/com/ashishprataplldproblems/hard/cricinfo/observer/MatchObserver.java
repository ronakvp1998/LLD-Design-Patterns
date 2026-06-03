package com.ashishprataplldproblems.hard.cricinfo.observer;

import com.ashishprataplldproblems.hard.cricinfo.entity.Match;
import com.ashishprataplldproblems.hard.cricinfo.entity.Ball;

public interface MatchObserver {
    void update(Match match, Ball lastBall);
}
