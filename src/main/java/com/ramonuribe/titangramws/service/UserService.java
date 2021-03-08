package com.ramonuribe.titangramws.service;

import com.ramonuribe.titangramws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);
    UserDto getUser(UserDto userDto);
    List<UserDto> getUsers();
    UserDto getUserByUsername(String username);

}
