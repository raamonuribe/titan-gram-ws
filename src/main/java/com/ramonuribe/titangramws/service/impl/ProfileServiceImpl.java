package com.ramonuribe.titangramws.service.impl;

import com.ramonuribe.titangramws.io.entity.ProfileEntity;
import com.ramonuribe.titangramws.io.entity.UserEntity;
import com.ramonuribe.titangramws.io.repository.ProfileRepository;
import com.ramonuribe.titangramws.io.repository.UserRepository;
import com.ramonuribe.titangramws.service.ProfileService;
import com.ramonuribe.titangramws.shared.dto.ProfileDto;
import com.ramonuribe.titangramws.shared.dto.UserDto;
import com.ramonuribe.titangramws.shared.utils.IdGeneratorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl  implements ProfileService {

    private final ModelMapper modelMapper;
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final IdGeneratorUtil idGenerator;

    @Autowired
    public ProfileServiceImpl(ModelMapper modelMapper, ProfileRepository profileRepository, UserRepository userRepository, IdGeneratorUtil idGenerator) {
        this.modelMapper = modelMapper;
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
    }

    @Override
    public ProfileDto createProfile(String userId, ProfileDto profileDto) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        // Add custom exception handling in v2
        if(userEntity == null) throw new RuntimeException("User not found.");

        UserDto userDto = modelMapper.map(userEntity, UserDto.class);
        profileDto.setUserDetails(userDto);
        profileDto.setProfileId(idGenerator.generateAlphaNumericId(30));

        ProfileEntity profileEntity = modelMapper.map(profileDto, ProfileEntity.class);
        ProfileEntity createdProfile = profileRepository.save(profileEntity);

        ProfileDto returnValue = modelMapper.map(createdProfile, ProfileDto.class);


        return returnValue;
    }

    @Override
    public ProfileDto updateProfile(String userId, String profileId, ProfileDto profileDto) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        if(userEntity == null) throw new RuntimeException("User not found.");
        ProfileEntity profileEntity = profileRepository.findByProfileId(profileId);
        if (profileEntity == null) throw new RuntimeException("Profile not found.");

        profileEntity.setBio(profileDto.getBio());
        profileEntity.setWebsite(profileDto.getWebsite());

        ProfileEntity updatedProfile = profileRepository.save(profileEntity);

        ProfileDto returnValue = modelMapper.map(updatedProfile, ProfileDto.class);

        return returnValue;
    }
}
