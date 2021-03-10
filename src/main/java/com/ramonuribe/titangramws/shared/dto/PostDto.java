package com.ramonuribe.titangramws.shared.dto;

import java.io.Serializable;
import java.util.List;

public class PostDto implements Serializable {
    private static final long serialVersionUID = 5407527944556839323L;

    private Long id;
    private String postId;
    private UserDto userDetails;
    private String caption;
    private String imageUrl;
    List<CommentDto> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public UserDto getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDto userDetails) {
        this.userDetails = userDetails;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
