package com.ashishprataplldproblems.hard.musicstreamingservice.strategies.recommendation;

import com.ashishprataplldproblems.hard.musicstreamingservice.entities.Song;

import java.util.List;

public interface RecommendationStrategy {
    List<Song> recommend(List<Song> allSongs);
}
