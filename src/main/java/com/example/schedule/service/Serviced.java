package com.example.schedule.service;

import com.example.schedule.dto.RequestDto;
import com.example.schedule.dto.ResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.entity.User;
import com.example.schedule.repository.MyRepository;
import org.springframework.stereotype.Service;

@Service
public class Serviced {

    // 속성
    private final MyRepository repository;


    // 생성자
    public Serviced(MyRepository repository) {
        this.repository = repository;
    }


    // 기능
    public ResponseDto createSchedule(RequestDto dto) {

        User user = new User(dto.getUserName(), dto.getPassword());
        Schedule schedule = new Schedule(dto.getSchedule());

        ResponseDto responseDto = repository.createSchedule(user, schedule);

        return responseDto;
    }
}
