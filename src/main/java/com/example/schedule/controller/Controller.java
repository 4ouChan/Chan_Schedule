package com.example.schedule.controller;

import com.example.schedule.dto.RequestDto;
import com.example.schedule.dto.ResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.service.Serviced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<ResponseDto> createSchedule(@RequestBody RequestDto dto) {

        ResponseEntity<ResponseDto> responseDto = new ResponseEntity<>(service.createSchedule(dto), HttpStatus.OK);

        return responseDto;
    }

    @GetMapping
    public List<ResponseDto> scheduleList() {

        return service.scheduleList();
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ResponseDto> getSchedule(@PathVariable long scheduleId) {
        ResponseDto getSchedule = service.getSchedule(scheduleId);
        return ResponseEntity.ok(getSchedule);
    }

}
