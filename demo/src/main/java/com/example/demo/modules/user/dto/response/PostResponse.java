package com.example.demo.modules.user.dto.response;

public record PostResponse(String title,
                           int id,
                           int userId,
                           String body) {
}
