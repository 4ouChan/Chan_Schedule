package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
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


    public ResponseDto(long scheduleId, String userName, String schedule) {
        this.userName = userName;
        this.scheduleId = scheduleId;
        this.schedule = schedule;
    }

    public ResponseDto(long scheduleId, String userName, String schedule, LocalDateTime createDate, LocalDateTime updateDate) {
        this.scheduleId = scheduleId;
        this.userName = userName;
        this.schedule = schedule;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

//    public ResponseDto(Schedule schedule) {
//        this.scheduleId = getScheduleId();
//        this.userName = getUserName();
//        this.schedule = getSchedule();
//        this.createDate = getCreateDate();
//        this.updateDate = getUpdateDate();
//    }
    public ResponseDto(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.userName = schedule.getUserName();
        this.schedule = schedule.getSchedule();
        this.createDate = schedule.getCreateDate();
        this.updateDate = schedule.getUpdateDate();
    }


}
