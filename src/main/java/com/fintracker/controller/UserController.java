package com.fintracker.controller;

import com.fintracker.entity.User;
import com.fintracker.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;


    @PostMapping("/register")
    public User register(@Valid @RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestParam String email,@RequestParam String password){
        return userService.login(email,password);
    }
}

