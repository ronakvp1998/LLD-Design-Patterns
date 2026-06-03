package com.ashishprataplldproblems.medium.linkedin.strategy;

import com.ashishprataplldproblems.medium.linkedin.entities.Post;

import java.util.List;

public interface FeedSortingStrategy {
    List<Post> sort(List<Post> posts);
}
