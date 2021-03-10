package com.ramonuribe.titangramws.ui.model.response;

import java.util.List;

public class UserRest {
    private String userId;
    private String username;
    private String firstName;
    private String lastName;
    private String avatar;
    private List<PostRest> posts;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<PostRest> getPosts() {
        return posts;
    }

    public void setPosts(List<PostRest> posts) {
        this.posts = posts;
    }
}
