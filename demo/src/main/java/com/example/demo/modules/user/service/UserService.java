package com.example.demo.modules.user.service;


import com.example.demo.modules.user.dto.request.UserRequest;
import com.example.demo.modules.user.model.UserModel;
import com.example.demo.modules.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

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
}
