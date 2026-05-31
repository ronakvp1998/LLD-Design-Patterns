package com.ashishprataplldproblems.socialnetworkingservice.service;

import com.ashishprataplldproblems.socialnetworkingservice.model.Post;
import com.ashishprataplldproblems.socialnetworkingservice.model.User;
import com.ashishprataplldproblems.socialnetworkingservice.strategy.ChronologicalStrategy;
import com.ashishprataplldproblems.socialnetworkingservice.strategy.NewsFeedGenerationStrategy;

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