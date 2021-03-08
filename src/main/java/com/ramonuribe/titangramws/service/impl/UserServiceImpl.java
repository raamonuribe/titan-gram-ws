package com.ramonuribe.titangramws.service.impl;

import com.ramonuribe.titangramws.io.entity.UserEntity;
import com.ramonuribe.titangramws.io.repository.UserRepository;
import com.ramonuribe.titangramws.service.UserService;
import com.ramonuribe.titangramws.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto getUser(UserDto userDto) {
        return null;
    }

    @Override
    public List<UserDto> getUsers() {
        return null;
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
