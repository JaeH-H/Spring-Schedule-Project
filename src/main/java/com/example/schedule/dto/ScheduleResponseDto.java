package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 응답 데이터를 처리하는 객체
 */

@Getter

public class ScheduleResponseDto {

    private Long id;
    private String name;
    private String title;
    private String contents;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.createDateTime = schedule.getCreateDateTime();
        this.updateDateTime = schedule.getUpdateDateTime();
    }

}
