package com.lldproblems.musicstreamingservice.strategies.playback;

import com.lldproblems.musicstreamingservice.enums.SubscriptionTier;
import com.lldproblems.musicstreamingservice.entities.Player;
import com.lldproblems.musicstreamingservice.entities.Song;

public interface PlaybackStrategy {
    void play(Song song, Player player);

    // Simple Factory method to get the correct strategy
    static PlaybackStrategy getStrategy(SubscriptionTier tier, int songsPlayed) {
        return tier == SubscriptionTier.PREMIUM ? new PremiumPlaybackStrategy() : new FreePlaybackStrategy(songsPlayed);
    }
}
