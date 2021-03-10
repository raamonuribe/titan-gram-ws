package com.ramonuribe.titangramws.shared.dto;

import java.io.Serializable;

public class CommentDto implements Serializable {
    private static final long serialVersionUID = -2707194816952498372L;

    private Long id;
    private String commentId;
    private UserDto userDetails;
    private PostDto postDetails;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public UserDto getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDto userDetails) {
        this.userDetails = userDetails;
    }

    public PostDto getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDto postDetails) {
        this.postDetails = postDetails;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
