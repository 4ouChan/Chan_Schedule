package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import com.example.schedule.entity.User;
import lombok.Getter;

@Getter
public class ResponseDto {

    // 속성
    private long userId;
    private String userName;
    private long scheduleId;
    private String schedule;

    // 생성자

    public ResponseDto(String userName, String schedule) {
        this.userName = userName;
        this.schedule = schedule;
    }

    public ResponseDto(long userId, String userName, long scheduleId, String schedule) {
        this.userId = userId;
        this.scheduleId = scheduleId;
        this.userName = userName;
        this.schedule = schedule;
    }


    // 기능

}
// 일정 생성 기능