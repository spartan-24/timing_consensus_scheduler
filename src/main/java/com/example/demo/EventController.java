package com.example.demo;

import com.example.demo.dto.EventRequest;
import com.example.demo.dto.EventRequestByEmail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/events")
@AllArgsConstructor
@Slf4j
public class EventController {
    private final EventService eventService;

    @PostMapping//C
    public void addEventsFromJson(@RequestBody EventRequest event){
        eventService.addEvent(event);
    }
    @GetMapping//R
    public List<Event> fetchAllEvents(){
        return eventService.getAllEvents();
    }
    @GetMapping("/getByEmail")
    public  List<Event> fetchAllEventsOfUserByEmail(@RequestBody EventRequestByEmail eventRequestByEmail){
        return eventService.getAllEventsOfUserByEmail(eventRequestByEmail);
    }
//    @PutMapping
//    public void updateEventFromJson(@RequestBody EventRequest eventRequest){
//        eventService.updateEvent(eventRequest);
//    }

}
