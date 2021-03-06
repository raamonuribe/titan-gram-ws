package com.ramonuribe.titangramws.ui.model.response;

import java.util.List;

public class PostRest {
    private String postId;
    private String imageUrl;
    private String caption;
    private String userId;
    private List<CommentRest> comments;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CommentRest> getComments() {
        return comments;
    }

    public void setComments(List<CommentRest> comments) {
        this.comments = comments;
    }
}
