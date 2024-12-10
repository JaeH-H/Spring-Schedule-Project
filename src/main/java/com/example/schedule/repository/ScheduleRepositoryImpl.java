package com.example.schedule.repository;

import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * 기능 수행(CRUD)
 */
@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    private final Map<Long, Schedule> scheduleList = new HashMap<>();


    //일정 생성
    @Override
    public Schedule saveSchedule(Schedule schedule) {

        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;
        schedule.setUpdateDateTime(schedule.getCreateDateTime());
        schedule.setId(scheduleId);
        scheduleList.put(scheduleId, schedule);

        return schedule;

    }

    //일정 전체 조회
    @Override
    public List<ScheduleResponseDto> findAllSchedules() {

        List<ScheduleResponseDto> allSchedules = new ArrayList<>(scheduleList.values().stream().map(ScheduleResponseDto::new).toList());
        Collections.sort(allSchedules, (o1, o2) -> o2.getUpdateDateTime().compareTo(o1.getUpdateDateTime()));

        return allSchedules;
    }

    //일정 선택 조회
    @Override
    public Schedule findAllScheduleByUserId(Long userId) {

        return scheduleList.get(userId);
    }

    //일정 부분 수정은 저장된 데이터를 직접 수정하므로 Repository에서 따로 수행하지 않는다.

    //일정 삭제
    @Override
    public void deleteSchedule(Long id) {

        scheduleList.remove(id);
    }
}
