package com.lldproblems.cricinfo.state;

import com.lldproblems.cricinfo.entity.Match;
import com.lldproblems.cricinfo.entity.Ball;

public class FinishedState implements MatchState {
    @Override
    public void processBall(Match match, Ball ball) {
        System.out.println("ERROR: Cannot process a ball for a finished match.");
    }
}
