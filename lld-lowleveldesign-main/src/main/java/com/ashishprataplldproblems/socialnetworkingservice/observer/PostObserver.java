package com.ashishprataplldproblems.socialnetworkingservice.observer;

import com.ashishprataplldproblems.socialnetworkingservice.model.Comment;
import com.ashishprataplldproblems.socialnetworkingservice.model.Post;
import com.ashishprataplldproblems.socialnetworkingservice.model.User;

public interface PostObserver {
    void onPostCreated(Post post);
    void onLike(Post post, User user);
    void onComment(Post post, Comment comment);
}