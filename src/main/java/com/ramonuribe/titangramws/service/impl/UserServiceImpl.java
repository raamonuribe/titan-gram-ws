package com.ramonuribe.titangramws.service.impl;

import com.ramonuribe.titangramws.io.entity.UserEntity;
import com.ramonuribe.titangramws.io.repository.UserRepository;
import com.ramonuribe.titangramws.service.UserService;
import com.ramonuribe.titangramws.shared.dto.UserDto;
import com.ramonuribe.titangramws.shared.utils.GravatarUtil;
import com.ramonuribe.titangramws.shared.utils.IdGeneratorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final IdGeneratorUtil idGenerator;
    private final GravatarUtil gravatar;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder, IdGeneratorUtil idGenerator, GravatarUtil gravatar) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.idGenerator = idGenerator;
        this.gravatar = gravatar;
    }

    @Override
    public UserDto createUser(UserDto userDto) {

        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);

        userEntity.setUserId(idGenerator.generateAlphaNumericId(30));
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userEntity.setAvatar(gravatar.generateGravatarImageUrl(userDto.getEmail()));

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = modelMapper.map(storedUserDetails, UserDto.class);

        return returnValue;


    }

    @Override
    public UserDto getUser(UserDto userDto) {
        return null;
    }

    @Override
    public List<UserDto> getUsers() {
        List<UserDto> returnValue = userRepository.findAll().stream().map(temp -> {
            return modelMapper.map(temp, UserDto.class);
        }).collect(Collectors.toList());

        return returnValue;
    }

    // SECURITY METHODS //


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);

        if(userEntity == null) throw new UsernameNotFoundException(username);

        return new User(userEntity.getUsername(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }

    public UserDto getUserByUsername(String username) {
        UserDto returnValue = new UserDto();
        UserEntity userEntity = userRepository.findByUsername(username);

        if(userEntity == null) throw new UsernameNotFoundException(username);

        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }
}
