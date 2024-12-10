package com.example.schedule.controller;


import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 생성자 주입
 * 클래스가 필요로 하는 의존성을 생성자를 통해 전달
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {


    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    //일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {

        return new ResponseEntity<>(scheduleService.saveSchedule(requestDto), HttpStatus.CREATED);

    }

    //일정 전체 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules() {

        return new ResponseEntity<>(scheduleService.findAllSchedule(), HttpStatus.OK);
    }

    //일정 선택 조회
    @GetMapping("{id}")
    public ResponseEntity<ScheduleResponseDto> findSchedule(@PathVariable Long id) {

        return new ResponseEntity<>(scheduleService.findAllScheduleByUserId(id), HttpStatus.OK);
    }

    //일정 부분 수정
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {

        return new ResponseEntity<>(scheduleService.updateSchedule(requestDto, id), HttpStatus.OK);

    }

    //일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> deleteSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {

        scheduleService.deleteSchedule(requestDto, id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
