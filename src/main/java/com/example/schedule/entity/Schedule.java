package com.example.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {

    // 속성
    private long scheduleId;
    private String userName;
    private String password;
    private String schedule;
    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime updateDate = LocalDateTime.now();

    // 생성자
    public Schedule(String userName, String password, String schedule) {
        this.userName = userName;
        this.password = password;
        this.schedule = schedule;
    }

    public Schedule(String userName, String schedule) {
        this.userName = userName;
        this.schedule = schedule;
    }

//    public Schedule(long scheduleId) {
//        this.scheduleId = scheduleId;
//    }



}
