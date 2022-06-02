package com.example.punto8.controller;

import com.example.punto8.RequestModel.RequestUser;
import com.example.punto8.model.User;
import com.example.punto8.service.UserService;
import org.apache.coyote.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/login")
    public ResponseEntity<User> login(@RequestBody RequestUser requestUser){
        return ResponseEntity.ok().body(userService.findBYNameAndPassword(requestUser.getName(), requestUser.getPassword()));
    }
}
