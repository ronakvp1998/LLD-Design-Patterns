package com.lldproblems.socialnetworkingservice.strategy;

import com.lldproblems.socialnetworkingservice.model.Post;
import com.lldproblems.socialnetworkingservice.model.User;

import java.util.List;

public interface NewsFeedGenerationStrategy {
    List<Post> generateFeed(User user);
}
