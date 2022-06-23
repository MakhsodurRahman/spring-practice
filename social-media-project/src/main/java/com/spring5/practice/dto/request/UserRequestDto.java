package com.spring5.practice.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserRequestDto {

    @NotBlank(message = "name cannot me empty")
    private String name;
    @Email
    private String email;
    private String password;
    private String role;
    private String locationName;
}
