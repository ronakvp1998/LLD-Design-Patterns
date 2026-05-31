package com.ashishprataplldproblems.linkedin.strategy;

import com.ashishprataplldproblems.linkedin.entities.Post;

import java.util.List;

public interface FeedSortingStrategy {
    List<Post> sort(List<Post> posts);
}
