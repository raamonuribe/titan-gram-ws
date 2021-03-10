package com.ramonuribe.titangramws.io.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comments")
public class CommentEntity implements Serializable {
    private static final long serialVersionUID = -2337074828403322606L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commentId;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userDetails;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity postDetails;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntity getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserEntity userDetails) {
        this.userDetails = userDetails;
    }

    public PostEntity getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostEntity postDetails) {
        this.postDetails = postDetails;
    }
}
