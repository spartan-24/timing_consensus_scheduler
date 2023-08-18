package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EventRequest {
    LocalDate date;
    ArrayList<Integer> slots;
    ArrayList<String> bookedByCalendarId;
    String bookedToCalendarId;
    String eventTitle;
}
