package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 요청하는 데이터를 처리하는 객체
 */

@Getter
public class ScheduleRequestDto {

    private String name;
    private String password;
    private String title;
    private String contents;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
}
