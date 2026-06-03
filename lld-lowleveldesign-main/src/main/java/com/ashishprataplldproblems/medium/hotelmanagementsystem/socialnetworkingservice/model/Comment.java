package com.ashishprataplldproblems.medium.hotelmanagementsystem.socialnetworkingservice.model;

import java.util.List;

public class Comment extends CommentableEntity {
    public Comment(User author, String content) {
        super(author, content);
    }

    public List<Comment> getReplies() {
        return getComments();
    }
}