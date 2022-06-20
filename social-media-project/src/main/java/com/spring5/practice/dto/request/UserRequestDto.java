package com.spring5.practice.dto.request;

import lombok.Data;

@Data
public class UserRequestDto {

    private String name;
    private String email;
    private String password;
    private String role;
    private String locationName;
}
