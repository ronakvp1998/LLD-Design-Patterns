package com.ashishprataplldproblems.medium.hotelmanagementsystem.socialnetworkingservice.observer;

import com.ashishprataplldproblems.medium.hotelmanagementsystem.socialnetworkingservice.model.Comment;
import com.ashishprataplldproblems.medium.hotelmanagementsystem.socialnetworkingservice.model.Post;
import com.ashishprataplldproblems.medium.hotelmanagementsystem.socialnetworkingservice.model.User;

public interface PostObserver {
    void onPostCreated(Post post);
    void onLike(Post post, User user);
    void onComment(Post post, Comment comment);
}