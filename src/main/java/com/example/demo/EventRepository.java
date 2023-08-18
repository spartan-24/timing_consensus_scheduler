package com.example.demo;

import com.example.demo.dto.SlotRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public interface EventRepository extends MongoRepository<Event, String> {
    Optional<Event> findEventByBookedToCalendarId (String calendarId);
    Optional<Event> findEventByBookedByCalendarId (String calendarId);
//    Optional<Event> findEventByDateAndBookedByCalendarIdIsNotContainingAndBookedToCalendarIdIsNot(LocalDate date, ArrayList<String> calIds1, String calIds2);
    ArrayList<Event> findEventsByDateIsAndBookedByCalendarIdIsNotContainingAndBookedToCalendarIdIsNot(LocalDate date, ArrayList<String> calIds1, String calIds2);
    ArrayList<Event> findEventsByDateIsAndBookedByCalendarIdContainsAndBookedToCalendarIdContaining(LocalDate date, ArrayList<String> calIds1, String calIds2);
    ArrayList<Event> findEventsByBookedByCalendarId(String st);
    //    void fetchFreeSlotsofDay(SlotRequest slotRequest);
//    Optional<Event> findEventByStart_timeIsGreaterThanEqualAndEnd_timeIsLessThanEqual(Date start_time, Date end_time);
//    Optional<Event> findEventByStartTimeGreaterThanEqualAndEndTimeIsLessThanEqual(Date startTime, Date endTime);
//    Optional<Event> findEventByBookedToCalendarIdAndStartTimeGreaterThanEqualAndEndTimeIsLessThanEqual(
//            String calId1, Date startTime, Date endTime
//    );
//    Optional<Event> findEventBy
}
