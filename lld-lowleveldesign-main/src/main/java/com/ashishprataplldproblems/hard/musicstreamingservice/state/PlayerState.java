package com.ashishprataplldproblems.hard.musicstreamingservice.state;

import com.ashishprataplldproblems.hard.musicstreamingservice.entities.Player;

public interface PlayerState {
    void play(Player player);
    void pause(Player player);
    void stop(Player player);
}
