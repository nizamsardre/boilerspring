package com.example.demo.modules.user.repository;

import com.example.demo.modules.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserModel, Long> {
}
