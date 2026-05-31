package com.lldproblems.cricinfo.observer;

import com.lldproblems.cricinfo.enums.MatchStatus;
import com.lldproblems.cricinfo.entity.Match;
import com.lldproblems.cricinfo.entity.Ball;

public class CommentaryDisplay implements MatchObserver {
    @Override
    public void update(Match match, Ball lastBall) {
        if (match.getCurrentStatus() == MatchStatus.FINISHED) {
            System.out.println("[COMMENTARY]: Match has finished!");
        } else if (match.getCurrentStatus() == MatchStatus.IN_BREAK) {
            System.out.println("[COMMENTARY]: Inning has ended!");
        } else {
            System.out.printf("[COMMENTARY]: %s%n", lastBall.getCommentary());
        }
    }
}