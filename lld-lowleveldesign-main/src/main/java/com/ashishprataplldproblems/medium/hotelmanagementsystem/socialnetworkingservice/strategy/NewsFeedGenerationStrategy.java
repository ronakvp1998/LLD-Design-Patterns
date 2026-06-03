package com.ashishprataplldproblems.medium.hotelmanagementsystem.socialnetworkingservice.strategy;

import com.ashishprataplldproblems.medium.hotelmanagementsystem.socialnetworkingservice.model.Post;
import com.ashishprataplldproblems.medium.hotelmanagementsystem.socialnetworkingservice.model.User;

import java.util.List;

public interface NewsFeedGenerationStrategy {
    List<Post> generateFeed(User user);
}
