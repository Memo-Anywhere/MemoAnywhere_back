package com.example.MemoAnywhere.service;

import com.example.MemoAnywhere.domain.CalendarEvent;
import com.example.MemoAnywhere.dto.CalendarEventDTO;
import com.example.MemoAnywhere.repository.CalendarEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CalendarEventService {
    private final CalendarEventRepository eventRepository;

    public CalendarEventDTO createEvent(Long groupId, LocalDate date, String task, LocalTime start_time, LocalTime end_time, boolean notification, boolean repeat, boolean is_com) {    // 일정 생성
        CalendarEvent event = CalendarEvent.builder()
                .group_id(groupId)
                .date(date)
                .task(task)
                .startTime(start_time)
                .endTime(end_time)
                .notification(notification)
                .repeat(repeat)
                .isCompleted(is_com)
                .build();

        CalendarEvent savedEvent = eventRepository.save(event);
        return CalendarEventDTO.of(savedEvent);
    }

    public CalendarEventDTO updateEvent(Long eventId, Long groupId, LocalDate date, String task, LocalTime start_time, LocalTime end_time, boolean notification, boolean repeat, boolean is_com) {     // 일정 업데이트
        Optional<CalendarEvent> event = eventRepository.findById(eventId);
        if (event.isPresent()) {
            CalendarEvent updatedEvent = event.get();
            updatedEvent.setGroup_id(groupId);
            updatedEvent.setDate(date);
            updatedEvent.setTask(task);
            updatedEvent.setStartTime(start_time);
            updatedEvent.setEndTime(end_time);
            updatedEvent.setNotification(notification);
            updatedEvent.setRepeat(repeat);
            updatedEvent.setIsCompleted(is_com);
            CalendarEvent savedEvent = eventRepository.save(updatedEvent);
            return CalendarEventDTO.of(savedEvent);
        } else {
            return null;
        }
    }

    public CalendarEventDTO getEventById(Long eventId) {   // 일정 정보 가져오기
        System.out.println("id: " + eventId);
        Optional<CalendarEvent> event = eventRepository.findById(eventId);
        System.out.println("user: " + event.get());
        return event.isPresent() ? CalendarEventDTO.of(event.get()) : null;
    }

    public boolean deleteEventById(Long eventId) {    // 일정 삭제하기
        Optional<CalendarEvent> event = eventRepository.findById(eventId);
        if (event.isPresent()) {
            eventRepository.deleteById(eventId);
            return true;
        } else {
            return false;
        }
    }
}
