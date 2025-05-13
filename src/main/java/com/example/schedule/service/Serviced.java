package com.example.schedule.service;

import com.example.schedule.dto.RequestDto;
import com.example.schedule.dto.ResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.MyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

        Schedule schedule = new Schedule(dto.getUserName(), dto.getPassword(), dto.getSchedule());

        ResponseDto responseDto = repository.createSchedule(schedule);

        return responseDto;
    }

    public List<ResponseDto> scheduleList() {
        return repository.scheduleList();
    }

}
