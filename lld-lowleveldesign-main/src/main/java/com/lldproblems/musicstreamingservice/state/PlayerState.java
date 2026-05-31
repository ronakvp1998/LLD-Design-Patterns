package com.lldproblems.musicstreamingservice.state;

import com.lldproblems.musicstreamingservice.entities.Player;

public interface PlayerState {
    void play(Player player);
    void pause(Player player);
    void stop(Player player);
}
