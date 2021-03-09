package com.ramonuribe.titangramws.io.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profiles")
public class ProfileEntity implements Serializable {
    private static final long serialVersionUID = -917100260779863923L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String profileId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userDetails;

    private String bio;
    private String website;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public UserEntity getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserEntity userDetails) {
        this.userDetails = userDetails;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
