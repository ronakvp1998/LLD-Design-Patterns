package com.ashishprataplldproblems.medium.hotelmanagementsystem.socialnetworkingservice.service;

import com.ashishprataplldproblems.medium.hotelmanagementsystem.socialnetworkingservice.model.Post;
import com.ashishprataplldproblems.medium.hotelmanagementsystem.socialnetworkingservice.model.User;
import com.ashishprataplldproblems.medium.hotelmanagementsystem.socialnetworkingservice.strategy.ChronologicalStrategy;
import com.ashishprataplldproblems.medium.hotelmanagementsystem.socialnetworkingservice.strategy.NewsFeedGenerationStrategy;

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