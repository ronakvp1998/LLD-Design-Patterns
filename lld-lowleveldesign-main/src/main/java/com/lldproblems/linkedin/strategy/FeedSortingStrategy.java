package com.lldproblems.linkedin.strategy;

import com.lldproblems.linkedin.entities.Post;

import java.util.List;

public interface FeedSortingStrategy {
    List<Post> sort(List<Post> posts);
}
