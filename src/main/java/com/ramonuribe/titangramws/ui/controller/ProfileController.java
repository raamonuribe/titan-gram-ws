package com.ramonuribe.titangramws.ui.controller;

import com.ramonuribe.titangramws.service.ProfileService;
import com.ramonuribe.titangramws.shared.dto.ProfileDto;
import com.ramonuribe.titangramws.ui.model.request.ProfileDetailsRequestModel;
import com.ramonuribe.titangramws.ui.model.response.ProfileRest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/{userId}/profiles")
public class ProfileController {
    private final ModelMapper modelMapper;
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ModelMapper modelMapper, ProfileService profileService) {
        this.modelMapper = modelMapper;
        this.profileService = profileService;
    }

    @PostMapping
    public ProfileRest createProfile(@PathVariable String userId, @RequestBody ProfileDetailsRequestModel profileDetails) {

        ProfileDto profileDto =  modelMapper.map(profileDetails, ProfileDto.class);
        ProfileDto createdProfile = profileService.createProfile(userId, profileDto);

        ProfileRest returnValue = modelMapper.map(createdProfile, ProfileRest.class);

        return returnValue;
    }
}
