package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 *비지니스 로직을 수행
 */

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;

    }

    //일정 생성
    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto) {

        Schedule schedule = new Schedule(requestDto);
        Schedule saveSchedule = scheduleRepository.saveSchedule(schedule);
        return new ScheduleResponseDto(saveSchedule);

    }

    //일정 전체 조회
    @Override
    public List<ScheduleResponseDto> findAllSchedule() {

        List<ScheduleResponseDto> allSchedules = scheduleRepository.findAllSchedules();
        return allSchedules;

    }

    //일정 선택 조회
    @Override
    public ScheduleResponseDto findAllScheduleByUserId(Long id) {

        Schedule schedule = scheduleRepository.findAllScheduleByUserId(id);
        return new ScheduleResponseDto(schedule);

    }

    //일정 수정
    @Override
    public ScheduleResponseDto updateSchedule(ScheduleRequestDto requestDto, Long id) {

        Schedule schedule = scheduleRepository.findAllScheduleByUserId(id);

        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (requestDto.getName() == null || requestDto.getContents() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if (schedule.getPassword().equals(requestDto.getPassword())) {
            schedule.updateSchedule(requestDto);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        schedule.updateSchedule(requestDto);

        return new ScheduleResponseDto(schedule);

    }

    //일정 삭제
    @Override
    public void deleteSchedule(ScheduleRequestDto requestDto, Long id) {

        Schedule schedule = scheduleRepository.findAllScheduleByUserId(id);

        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (schedule.getPassword().equals(requestDto.getPassword())) {
            scheduleRepository.deleteSchedule(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

}
