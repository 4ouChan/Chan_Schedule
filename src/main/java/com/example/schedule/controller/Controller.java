package com.example.schedule.controller;

import com.example.schedule.dto.RequestDto;
import com.example.schedule.dto.ResponseDto;
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

        ResponseEntity<ResponseDto> responseDto = new ResponseEntity<>(service.createSchedule(dto), HttpStatus.CREATED);

        return responseDto;
    }


    @GetMapping
    public List<ResponseDto> scheduleList() {

        return service.scheduleList();
    }


    @GetMapping("/{scheduleId}")
    public ResponseEntity<ResponseDto> getSchedule(@PathVariable long scheduleId) {

        ResponseEntity<ResponseDto> getSchedule = new ResponseEntity<>(service.getSchedule(scheduleId), HttpStatus.OK);

        return getSchedule;
    }


    @PutMapping("/{scheduleId}")
    public ResponseEntity<ResponseDto> updateSchedule(
            @PathVariable long scheduleId,
            @RequestBody RequestDto dto
    ) {

        ResponseEntity<ResponseDto> updateSchedule = new ResponseEntity<>(service.updateSchedule(scheduleId, dto), HttpStatus.OK);

        return updateSchedule;
    }


    @DeleteMapping("/{scheduleId}")
    public List<ResponseDto> deleteSchedule(
            @PathVariable long scheduleId,
            @RequestBody RequestDto dto
    ) {

        return service.deleteSchedule(scheduleId, dto);
    }
}
