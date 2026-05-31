package com.ashishprataplldproblems.musicstreamingservice.state;

import com.ashishprataplldproblems.musicstreamingservice.entities.Player;

public interface PlayerState {
    void play(Player player);
    void pause(Player player);
    void stop(Player player);
}
