package com.spring5.practice.dto.request;

import lombok.Data;

@Data
public class StatusRequestDto {

    String title;

    String description;

    String location;

    String user;

    String privacy;

    String attachmentPath;
}
