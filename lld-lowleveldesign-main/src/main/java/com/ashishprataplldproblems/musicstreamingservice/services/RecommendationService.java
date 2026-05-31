package com.ashishprataplldproblems.musicstreamingservice.services;

import com.ashishprataplldproblems.musicstreamingservice.entities.Song;
import com.ashishprataplldproblems.musicstreamingservice.strategies.recommendation.RecommendationStrategy;

import java.util.List;

public class RecommendationService {
    private RecommendationStrategy strategy;

    public RecommendationService(RecommendationStrategy strategy) { this.strategy = strategy; }

    public void setStrategy(RecommendationStrategy strategy) { this.strategy = strategy; }

    public List<Song> generateRecommendations(List<Song> allSongs) {
        return strategy.recommend(allSongs);
    }
}
