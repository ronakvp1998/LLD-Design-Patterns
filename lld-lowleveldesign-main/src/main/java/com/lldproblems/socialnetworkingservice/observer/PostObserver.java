package com.lldproblems.socialnetworkingservice.observer;

import com.lldproblems.socialnetworkingservice.model.Comment;
import com.lldproblems.socialnetworkingservice.model.Post;
import com.lldproblems.socialnetworkingservice.model.User;

public interface PostObserver {
    void onPostCreated(Post post);
    void onLike(Post post, User user);
    void onComment(Post post, Comment comment);
}