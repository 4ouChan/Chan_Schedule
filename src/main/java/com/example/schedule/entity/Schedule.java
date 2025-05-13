package com.example.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Schedule {

    // 속성
    @Setter
    private long userId;
    private String userName;
    private String password;
    private long scheduleId;
    private String schedule;

    // 생성자
    public Schedule(String schedule) {
        this.schedule = schedule;
    }

}
// 일정 생성 기능