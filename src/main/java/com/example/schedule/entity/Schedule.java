package com.example.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
public class Schedule {

    // 속성
    private long userId;
    private String userName;
    private String password;
    private long scheduleId;
    private String schedule;
    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime updateDate = LocalDateTime.now();

    // 생성자
    public Schedule(String userName, String password, String schedule) {
        this.userName = userName;
        this.password = password;
        this.schedule = schedule;
    }

}
