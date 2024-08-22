package com.example.MemoAnywhere.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalendarEventDTO {
    private Long eventId;
    private Long userGroupId;
    private LocalDate date;
    private String task;
    private LocalTime startTime;
    private LocalTime endTime;
    private Boolean notification;
    private Boolean repeat;
    private Boolean isCompleted;
}