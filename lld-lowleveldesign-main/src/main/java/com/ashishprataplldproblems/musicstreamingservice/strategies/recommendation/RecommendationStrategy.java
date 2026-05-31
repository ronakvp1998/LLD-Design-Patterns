package com.ashishprataplldproblems.musicstreamingservice.strategies.recommendation;

import com.ashishprataplldproblems.musicstreamingservice.entities.Song;

import java.util.List;

public interface RecommendationStrategy {
    List<Song> recommend(List<Song> allSongs);
}
