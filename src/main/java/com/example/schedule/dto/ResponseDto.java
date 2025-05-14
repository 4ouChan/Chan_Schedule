package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResponseDto {

    // 속성
    private long scheduleId;
    private String userName;
    private String password;
    private String schedule;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public ResponseDto(long scheduleId, String userName, String schedule, LocalDateTime createDate, LocalDateTime updateDate) {
        this.scheduleId = scheduleId;
        this.userName = userName;
        this.schedule = schedule;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }




}
