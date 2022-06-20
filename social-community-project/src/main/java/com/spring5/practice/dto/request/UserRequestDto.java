package com.spring5.practice.dto.request;

import lombok.Data;

@Data
public class User {
    private String name;
    private String password;
    private String locationName;
}
