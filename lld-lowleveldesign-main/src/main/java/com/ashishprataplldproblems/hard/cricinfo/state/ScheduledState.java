package com.ashishprataplldproblems.hard.cricinfo.state;

import com.ashishprataplldproblems.hard.cricinfo.entity.Match;
import com.ashishprataplldproblems.hard.cricinfo.entity.Ball;

public class ScheduledState implements MatchState {
    @Override
    public void processBall(Match match, Ball ball) {
        System.out.println("ERROR: Cannot process a ball for a match that has not started.");
    }
}
