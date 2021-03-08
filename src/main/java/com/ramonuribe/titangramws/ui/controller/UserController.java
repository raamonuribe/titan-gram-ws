package com.ramonuribe.titangramws.ui.controller;

import com.ramonuribe.titangramws.ui.model.request.UserDetailsRequestModel;
import com.ramonuribe.titangramws.ui.model.response.UserRest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping
    public String getAllUsers() {
        return "GET Users";
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
    public String createUser(@RequestBody UserDetailsRequestModel userDetails) {
        return "User Registered";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "Deleted User";
    }
}
