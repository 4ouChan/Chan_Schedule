package com.example.schedule.controller;

import com.example.schedule.dto.RequestDto;
import com.example.schedule.dto.ResponseDto;
import com.example.schedule.service.Serviced;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
public class Controller {

    // 속성
    private final Serviced service;

    // 생성자
    public Controller(Serviced service) {
        this.service = service;
    }

    // 기능
    @PostMapping
    public ResponseDto createSchedule(@RequestBody RequestDto dto) {

        ResponseDto responseDto = service.createSchedule(dto);

        return responseDto;
    }

}
