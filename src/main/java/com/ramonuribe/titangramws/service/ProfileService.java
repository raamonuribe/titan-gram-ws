package com.ramonuribe.titangramws.service;

import com.ramonuribe.titangramws.shared.dto.ProfileDto;

import java.util.List;

public interface ProfileService {
    ProfileDto createProfile(String userId, ProfileDto profileDto);
    ProfileDto updateProfile(String userId, String profileId, ProfileDto profileDto);
    List<ProfileDto> getProfiles();
    ProfileDto getByProfileId(String userId, String profileId);
}
