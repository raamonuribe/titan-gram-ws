package com.ramonuribe.titangramws.ui.controller;

import com.ramonuribe.titangramws.service.UserService;
import com.ramonuribe.titangramws.shared.dto.UserDto;
import com.ramonuribe.titangramws.ui.model.request.UserDetailsRequestModel;
import com.ramonuribe.titangramws.ui.model.response.UserRest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers() {
        return "Find Users";
    }

    @GetMapping("/{userId}")
    public String getByUserId(@PathVariable String userId) {
        return "Found By userId";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable String userId, @RequestBody UserDetailsRequestModel userDetails) {
        return "Updated User";
    }

    @PostMapping("/register")
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {

        UserDto userDto = modelMapper.map(userDetails, UserDto.class);
        UserDto createdUser = userService.createUser(userDto);

        UserRest returnValue = modelMapper.map(createdUser, UserRest.class);

        return returnValue;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "Deleted User";
    }
}
