package com.ashishprataplldproblems.musicstreamingservice.strategies.playback;

import com.ashishprataplldproblems.musicstreamingservice.enums.SubscriptionTier;
import com.ashishprataplldproblems.musicstreamingservice.entities.Player;
import com.ashishprataplldproblems.musicstreamingservice.entities.Song;

public interface PlaybackStrategy {
    void play(Song song, Player player);

    // Simple Factory method to get the correct strategy
    static PlaybackStrategy getStrategy(SubscriptionTier tier, int songsPlayed) {
        return tier == SubscriptionTier.PREMIUM ? new PremiumPlaybackStrategy() : new FreePlaybackStrategy(songsPlayed);
    }
}
