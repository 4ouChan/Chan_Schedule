package com.example.schedule.dto;

//import com.example.schedule.entity.User;
import com.example.schedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class ResponseDto {

    // 속성
    private long userId;
    private String userName;
    private String password;
    private long scheduleId;
    private String schedule;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;


    public ResponseDto(long userId, String userName, long scheduleId, String schedule) {
        this.userId = userId;
        this.userName = userName;
        this.scheduleId = scheduleId;
        this.schedule = schedule;
    }

    public ResponseDto(long userId, String userName, long scheduleId, String schedule, LocalDateTime createDate, LocalDateTime updateDate) {
        this.userId = userId;
        this.userName = userName;
        this.scheduleId = scheduleId;
        this.schedule = schedule;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public ResponseDto(Schedule schedule) {
        this.userId = getUserId();
        this.userName = getUserName();
        this.scheduleId = getScheduleId();
        this.schedule = getSchedule();
        this.createDate = getCreateDate();
        this.updateDate = getUpdateDate();
    }


}
