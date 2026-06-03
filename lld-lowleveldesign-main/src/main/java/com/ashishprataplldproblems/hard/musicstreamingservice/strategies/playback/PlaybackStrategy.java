package com.ashishprataplldproblems.hard.musicstreamingservice.strategies.playback;

import com.ashishprataplldproblems.hard.musicstreamingservice.enums.SubscriptionTier;
import com.ashishprataplldproblems.hard.musicstreamingservice.entities.Player;
import com.ashishprataplldproblems.hard.musicstreamingservice.entities.Song;

public interface PlaybackStrategy {
    void play(Song song, Player player);

    // Simple Factory method to get the correct strategy
    static PlaybackStrategy getStrategy(SubscriptionTier tier, int songsPlayed) {
        return tier == SubscriptionTier.PREMIUM ? new PremiumPlaybackStrategy() : new FreePlaybackStrategy(songsPlayed);
    }
}
