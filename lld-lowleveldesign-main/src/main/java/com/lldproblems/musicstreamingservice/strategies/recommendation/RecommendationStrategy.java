package com.lldproblems.musicstreamingservice.strategies.recommendation;

import com.lldproblems.musicstreamingservice.entities.Song;

import java.util.List;

public interface RecommendationStrategy {
    List<Song> recommend(List<Song> allSongs);
}
