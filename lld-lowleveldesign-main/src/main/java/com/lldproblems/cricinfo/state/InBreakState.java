package com.lldproblems.cricinfo.state;

import com.lldproblems.cricinfo.enums.MatchStatus;
import com.lldproblems.cricinfo.entity.Ball;
import com.lldproblems.cricinfo.entity.Match;

public class InBreakState implements MatchState {
    @Override
    public void processBall(Match match, Ball ball) {
        System.out.println("ERROR: Cannot process a ball. The match is currently in a break.");
    }

    @Override
    public void startNextInnings(Match match) {
        System.out.println("Starting the next innings...");
        match.createNewInnings();
        match.setState(new LiveState());
        match.setCurrentStatus(MatchStatus.LIVE);
    }
}
