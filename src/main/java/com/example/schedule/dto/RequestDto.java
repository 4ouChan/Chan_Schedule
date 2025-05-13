package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class RequestDto {

    private String userName;
    private String password;
    private String schedule;
    private long scheduleId;

    public RequestDto(String userName, String password, String schedule) {
        this.userName = userName;
        this.password = password;
        this.schedule = schedule;
    }



}
