package com.example.demo.modules.user.dto.request;

import jakarta.validation.constraints.*;

public record UserRequest(String firstName,
//                          @Email(message = "invalid email address")
//                          String email,
//                          @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered ")
//                          String mobile,
//                          String gender,
//                          @Min(18)
//                          @Max(60)
//                          int age,
//                          @NotBlank
//                          String nationality,
                          String lastName) {
}
