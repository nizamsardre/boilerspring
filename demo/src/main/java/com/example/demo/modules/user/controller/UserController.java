package com.example.demo.modules.user.controller;


import com.example.demo.modules.user.dto.request.UserRequest;
import com.example.demo.modules.user.model.UserModel;
import com.example.demo.modules.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public String registerUser(@RequestBody UserRequest registrationRequest){
        UserModel user = userService.registerUser(registrationRequest);
        return "Success";
    }
    @GetMapping
    public List<UserModel> getUsers(){
        return userService.getUsers();
    }
}
