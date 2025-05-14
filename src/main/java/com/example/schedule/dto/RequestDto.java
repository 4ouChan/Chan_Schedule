package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RequestDto {

    private String userName;
    private String password;
    private String schedule;
    private LocalDateTime updateDate = LocalDateTime.now();

}
