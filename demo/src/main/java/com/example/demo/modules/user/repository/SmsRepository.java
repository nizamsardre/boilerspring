package com.example.demo.modules.user.repository;

import com.example.demo.modules.user.model.SmsLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsRepository extends JpaRepository<SmsLog, Long> {
}
