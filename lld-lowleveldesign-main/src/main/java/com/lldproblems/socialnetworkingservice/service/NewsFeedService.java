package com.lldproblems.socialnetworkingservice.service;

import com.lldproblems.socialnetworkingservice.model.Post;
import com.lldproblems.socialnetworkingservice.model.User;
import com.lldproblems.socialnetworkingservice.strategy.ChronologicalStrategy;
import com.lldproblems.socialnetworkingservice.strategy.NewsFeedGenerationStrategy;

import java.util.List;

public class NewsFeedService {
    private NewsFeedGenerationStrategy strategy;

    public NewsFeedService() {
        this.strategy = new ChronologicalStrategy(); // Default strategy
    }

    public void setStrategy(NewsFeedGenerationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Post> getNewsFeed(User user) {
        return strategy.generateFeed(user);
    }
}