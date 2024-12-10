package com.example.schedule.entity;

import com.example.schedule.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {

    @Setter
    private Long id;
    private String name;
    private String password;
    private String title;
    private String contents;
    private LocalDateTime createDateTime;
    @Setter
    private LocalDateTime updateDateTime;


    public Schedule(ScheduleRequestDto requestDto) {
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.createDateTime = LocalDateTime.now();
    }

    public void updateSchedule(ScheduleRequestDto requestDto) {
        this.name = requestDto.getName();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
        this.updateDateTime = LocalDateTime.now();
    }

}

