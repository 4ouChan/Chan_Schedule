package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RequestDto {

    private String userName;
    private String password;
    private String schedule;
    private LocalDateTime updateDate = LocalDateTime.now();

    public RequestDto() {

    }

    public RequestDto(String userName, String password, String schedule) {
        this.userName = userName;
        this.password = password;
        this.schedule = schedule;
    }

    public RequestDto(String userName, String password, String schedule, LocalDateTime updateDate) {
        this.userName = userName;
        this.password = password;
        this.schedule = schedule;
        this.updateDate = updateDate;
    }



}
