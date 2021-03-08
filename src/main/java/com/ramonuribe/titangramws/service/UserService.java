package com.ramonuribe.titangramws.service;

import com.ramonuribe.titangramws.shared.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUser(UserDto userDto);
    List<UserDto> getUsers();

}
