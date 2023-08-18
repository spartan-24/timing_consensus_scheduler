package com.example.demo;

import com.example.demo.dto.AuthenticationRequest;
import com.example.demo.dto.SlotRequest;
import com.example.demo.dto.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final CalendarController calendarController;
    private final FacilityService facilityService;
    public void addUser(UserRequest userRequest){

        String email1=userRequest.getEmail();
        userRepository.findUserByEmail(email1)
                .ifPresentOrElse(u->{
                    System.out.println(u+" Already exists");
                },()->{
                    Calendar calendar= new Calendar();
                    calendarController.addCalendar(calendar);
                    System.out.println(calendar.calendarId);
                    User user= new User(userRequest.getEmail(), userRequest.getPassword(), userRequest.getName(), userRequest.getRole(),
                             calendar.calendarId);
                    System.out.println("Inserting user: "+ user);
//                    calendarRepository.insert(calendar1);
                    userRepository.insert(user);
                    System.out.println("hogaya");
                });
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public void updateUser(User user) {
        String email1=user.email;
        userRepository.findUserByEmail(email1)
                .ifPresentOrElse(u->{
                    u=user;
                },()->{
                    System.out.println("User not present, So creating a new user");
                    userRepository.insert(user);
                });
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User getCalendarIdByEmail(String email) {
//        String email= userRequest.getEmail();
        Optional<User> userOptional = userRepository.findUserByEmail(email);
        User user = userOptional.orElse(new User());
        if (user.getUserId() == null) {
            System.out.println("User not found");
            return null;
        }
        return user;

    }
    public String loginUser(AuthenticationRequest loginRequest){
        String email1=loginRequest.getEmail();
        userRepository.findUserByEmail(email1)
                .ifPresentOrElse(u->{        },()->{
                    System.out.println("User not found error!!");
                });
        return loginRequest.getEmail();
    }


        public ArrayList<Integer> fetchFreeSlotsOfDay(SlotRequest slotRequest) {
        LocalDate date= slotRequest.getDate();
        ArrayList<String> bookedByCalIds= slotRequest.getBookedByUsers();
//        ArrayList<String> bookedByCalIds = null;
//        for(int i=0;i<bookedByUsers.size();i++){
//            User user= getCalendarIdByEmail(bookedByUsers.get(i));
//            String cal= user.getCalendarId();
//            bookedByCalIds.add(cal);
//        }

        String bookedToCalId=slotRequest.getBookedToUser();
//        if(slotRequest.getBookedToType()=="Faculty") {
//            String bookedToUser = slotRequest.getBookedToUser();
//            User user = getCalendarIdByEmail(bookedToUser);
//            bookedToCalId = user.getCalendarId();
//        }
//        else if(slotRequest.getBookedToType()=="Facility"){
//            String bookedToUser = slotRequest.getBookedToUser();
////            User  = getCalendarIdByEmail(bookedToUser);
//            bookedToCalId = facilityService.getCalIdByName(bookedToUser);
//        }


        ArrayList<Event> events= eventRepository.findEventsByDateIsAndBookedByCalendarIdContainsAndBookedToCalendarIdContaining(date, bookedByCalIds, bookedToCalId);
        int sz= events.size();
        ArrayList<Integer> slots = new ArrayList<Integer>();
        for(int i=0;i<48;i++){
            slots.add(1);
        }
        for(int i=0;i<sz;i++){
            Event event= events.get(i);
            int s= event.slot;
            slots.set(s - 1, 0);
        }
        return slots;

    }
}
