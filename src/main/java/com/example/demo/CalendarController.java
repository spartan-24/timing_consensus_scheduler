package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/calendars")
@AllArgsConstructor
public class CalendarController {
    private final CalendarService calendarService;

    @PostMapping//C
    public void addCalendar(Calendar calendar){
        calendarService.addCalendar(calendar);
    }

    @GetMapping//R
    public List<Calendar> fetchAllUsersCalendars(){
        return calendarService.getAllCalendars();
    }

//    @PutMapping//U
//    public void updateUser(User user){
//        userService.updateUser(user);
//    }

    @DeleteMapping//D
    public void deleteCalendar(Calendar calendar){
        calendarService.deleteCalendar(calendar);
    }
}
