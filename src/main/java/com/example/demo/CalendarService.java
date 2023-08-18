package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CalendarService {

    private final CalendarRepository calendarRepository;
    public void addCalendar(Calendar calendar) {
        try{calendarRepository.insert(calendar);}
        catch (Exception e){
            System.out.println("Cannot insert");
        }
    }

    public List<Calendar> getAllCalendars() {
        return calendarRepository.findAll();
    }

    public void deleteCalendar(Calendar calendar) {
        try{calendarRepository.delete(calendar);}
        catch (Exception e){
            System.out.println("Cannot delete");
        }
    }
}
