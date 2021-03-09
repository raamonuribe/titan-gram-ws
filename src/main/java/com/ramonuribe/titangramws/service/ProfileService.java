package com.ramonuribe.titangramws.service;

import com.ramonuribe.titangramws.shared.dto.ProfileDto;

public interface ProfileService {
    ProfileDto createProfile(String userId, ProfileDto profileDto);
}
