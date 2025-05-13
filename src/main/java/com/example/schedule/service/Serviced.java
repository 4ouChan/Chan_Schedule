package com.example.schedule.service;

import com.example.schedule.dto.RequestDto;
import com.example.schedule.dto.ResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.MyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

        Schedule schedule = new Schedule(dto.getUserName(), dto.getSchedule());

        ResponseDto responseDto = repository.createSchedule(schedule);

        return responseDto;
    }

    public List<ResponseDto> scheduleList() {
        return repository.scheduleList();
    }

    public ResponseDto getSchedule(long id) {

        return repository.getSchedule(id);
    }

    public ResponseDto updateSchedule(long id, RequestDto dto) {

        ResponseDto schedule = repository.getSchedule(id);

        if (dto.getPassword().equals(repository.getSchedule(id).getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            int updateSchedule = repository.updateSchedule(id, dto.getUserName(), dto.getSchedule(), dto.getPassword());
        }


        ResponseDto updateSchedule = repository.getSchedule(id);

        return updateSchedule;
    }

}
