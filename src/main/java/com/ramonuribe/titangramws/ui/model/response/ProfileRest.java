package com.ramonuribe.titangramws.ui.model.response;

public class ProfileRest {
    private String profileId;
    private UserRest userDetails;
    private String bio;
    private String website;

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public UserRest getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserRest userDetails) {
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
