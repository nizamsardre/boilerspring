package com.example.demo.modules.user.controller;


import com.example.demo.base.BaseResponse;
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
    public BaseResponse<UserModel> registerUser(@RequestBody UserRequest registrationRequest){
        BaseResponse<UserModel> response = new BaseResponse<>();
        UserModel user = userService.registerUser(registrationRequest);
        response.setData(user);
        return response;
    }
    @GetMapping
    public BaseResponse<List<UserModel>> getUsers(){
        BaseResponse<List<UserModel>> response = new BaseResponse<>();
        response.setData(userService.getUsers());
        return response;
    }
}
