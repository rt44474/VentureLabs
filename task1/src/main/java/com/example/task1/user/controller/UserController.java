package com.example.task1.user.controller;

import com.example.task1.user.dto.UserDto;
import com.example.task1.user.entity.User;
import com.example.task1.user.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/blog", params = {"action", "user", "password"})
    public ResponseEntity<UserDto> login(@RequestParam String action, @RequestParam String user, @RequestParam String password) {
        if (action.equals("login")) {
            UserDto loginUser = userServiceI.findUserByUsername(user);
            authenticate(loginUser.getUsername(), loginUser.getPassword());
            return ResponseEntity.ok(loginUser);
        } else {
            return null;
        }
    }

    @PostMapping(value = "/blog", params = {"action", "username", "password", "permission", "readonly"})
    public ResponseEntity<User> addNewUser(@RequestParam String action, @RequestParam String username, @RequestParam String password,
                                           @RequestParam String permission, @RequestParam String readonly) {
        if (action.equals("new_user")) {
            return ResponseEntity.ok(userServiceI.addUser(username, password, permission, readonly));
        } else {
            return null;
        }

    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

}
