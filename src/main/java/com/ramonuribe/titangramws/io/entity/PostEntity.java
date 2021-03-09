package com.ramonuribe.titangramws.io.entity;

import com.ramonuribe.titangramws.shared.dto.UserDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "posts")
public class PostEntity implements Serializable {
    private static final long serialVersionUID = -1888495605983367082L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postId;
    private String caption;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userDetails;

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

    public UserEntity getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserEntity userDetails) {
        this.userDetails = userDetails;
    }
}
