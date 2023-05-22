package com.example.demo.modules.user.controller;


import com.example.demo.base.BaseResponse;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.modules.user.dto.request.UserRequest;
import com.example.demo.modules.user.dto.response.PostResponse;
import com.example.demo.modules.user.dto.response.SmsResponse;
import com.example.demo.modules.user.model.UserModel;
import com.example.demo.modules.user.service.UserService;
import com.example.demo.rest.RestFeign;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.StringReader;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final RestFeign restFeign;

    @PostMapping
    public BaseResponse<UserModel> registerUser(@RequestBody @Valid UserRequest registrationRequest){
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

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping("/send-sms")
    public BaseResponse<SmsResponse> sendSms() throws JAXBException {
        BaseResponse<SmsResponse> response = new BaseResponse<>();
        String s = restFeign.smsSend();


        StringReader sr = new StringReader(s);
        JAXBContext jaxbContext = JAXBContext.newInstance(SmsResponse.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SmsResponse smsResponse = (SmsResponse) unmarshaller.unmarshal(sr);
        response.setData(smsResponse);
        return response;
       // return  restFeign.smsSend();

    }
}
