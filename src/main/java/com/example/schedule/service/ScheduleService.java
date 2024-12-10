package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;


import java.util.List;

public interface ScheduleService {
    ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto);

    List<ScheduleResponseDto> findAllSchedule();

    ScheduleResponseDto findAllScheduleByUserId(Long id);

    ScheduleResponseDto updateSchedule(ScheduleRequestDto requestDto, Long id);

    void deleteSchedule(ScheduleRequestDto requestDto, Long id);
}
