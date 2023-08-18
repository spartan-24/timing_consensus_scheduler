package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Data
@Document
public class Event {
    @Id
    String EventId;
    LocalDate date;
    int slot;
    ArrayList<String> bookedByCalendarId;
    String bookedToCalendarId;
    String eventTitle;

    public Event(LocalDate date, int slot, ArrayList<String> bookedByCalendarId, String bookedToCalendarId, String eventTitle) {
        this.date = date;
        this.slot = slot;
        this.bookedByCalendarId = bookedByCalendarId;
        this.bookedToCalendarId = bookedToCalendarId;
        this.eventTitle = eventTitle;
    }
}
