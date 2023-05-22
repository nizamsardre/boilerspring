package com.example.demo.modules.user.service;


import com.example.demo.exception.UserNotFoundException;
import com.example.demo.modules.user.dto.request.UserRequest;
import com.example.demo.modules.user.dto.response.SmsResponse;
import com.example.demo.modules.user.model.UserModel;
import com.example.demo.modules.user.repository.UserRepository;
import com.example.demo.rest.RestFeign;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RestFeign restFeign;

    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }


    public UserModel registerUser(UserRequest request) {
//        Optional<User> user = this.findByEmail(request.email());
//        if (user.isPresent()){
//            throw new UserAlreadyExistsException(
//                    "User with email "+request.email() + " already exists");
//        }
        var newUser = new UserModel();
        newUser.setFirstName(request.firstName());
        newUser.setLastName(request.lastName());
//        newUser.setEmail(request.email());
//        newUser.setPassword(passwordEncoder.encode(request.password()));
//        newUser.setRole(request.role());
        return userRepository.save(newUser);
    }

    public UserModel getUser(long id) throws UserNotFoundException {
        UserModel user= userRepository.findById(id);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("user not found with id : "+id);
        }
    }

    public SmsResponse sendSms() throws JAXBException {
        String apiResponse = restFeign.smsSend("hi paul");
        StringReader sr = new StringReader(apiResponse);
        JAXBContext jaxbContext = JAXBContext.newInstance(SmsResponse.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SmsResponse smsResponse = (SmsResponse) unmarshaller.unmarshal(sr);
        return  smsResponse;
    }
}
