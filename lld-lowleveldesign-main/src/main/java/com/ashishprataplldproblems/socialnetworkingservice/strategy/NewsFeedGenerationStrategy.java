package com.ashishprataplldproblems.socialnetworkingservice.strategy;

import com.ashishprataplldproblems.socialnetworkingservice.model.Post;
import com.ashishprataplldproblems.socialnetworkingservice.model.User;

import java.util.List;

public interface NewsFeedGenerationStrategy {
    List<Post> generateFeed(User user);
}
