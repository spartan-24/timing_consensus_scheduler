package com.example.demo;

import com.example.demo.dto.EventRequest;
import com.example.demo.dto.EventRequestByEmail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class EventService {

    private final EventRepository eventRepository;
    private final UserService userService;

    public void addEvent(EventRequest event) {//implementation pending
        ArrayList<Integer> slots=event.getSlots();
        for(int i=0;i<slots.size();i++){
            if(slots.get(i)>48 || slots.get(i)<1){
                System.out.println("Only slots 1-48 available");
                return;
            }
        }
        for(int i=0;i<slots.size();i++){
            Event event1= new Event(
                    event.getDate(), slots.get(i), event.getBookedByCalendarId(), event.getBookedToCalendarId(), event.getEventTitle()
            );
            eventRepository.insert(event1);
        }

//                });


    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getAllEventsOfUserByEmail(EventRequestByEmail eventRequestByEmail) {
        User user=userService.getCalendarIdByEmail(eventRequestByEmail.getEmail());
        return eventRepository.findEventsByBookedByCalendarId(user.getCalendarId());
    }

//    public void updateEvent(EventRequest eventRequest) {//implementation pending
//        Event event= new Event(
//                eventRequest.getDate(), eventRequest.getSlot(), eventRequest.getBookedByCalendarId(), eventRequest.getBookedToCalendarId()
//        );
//        String bookedToCalendarId= event1.bookedToCalendarId;
//        Date start_time= event1.startTime;
//        Date end_time= event1.endTime;
//        eventRepository.findEventByBookedToCalendarIdAndStartTimeGreaterThanEqualAndEndTimeIsLessThanEqual(
//                        bookedToCalendarId, start_time, end_time
//                )
//                .ifPresentOrElse(e->{
//                    eventRepository.insert(event);
//                },()->{
////                    eventRepository.insert(event1);
//                    System.out.println("Slot does not exist");
//                });


//    }
}
