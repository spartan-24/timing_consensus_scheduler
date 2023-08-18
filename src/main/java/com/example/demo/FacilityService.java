package com.example.demo;

import com.example.demo.dto.FacilityRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FacilityService {

    private final FacilityRepository facilityRepository;
    private final CalendarController calendarController;

    public void addFacility(FacilityRequest facilityRequest) {
                String name1=facilityRequest.getName();
        facilityRepository.findFacilityByName(name1)
                .ifPresentOrElse(n->{
                    System.out.println(n+" Already exists");
                },()->{
                    Calendar calendar= new Calendar();
                    calendarController.addCalendar(calendar);
                    System.out.println(calendar.calendarId);
                    Facility facility= new Facility(facilityRequest.getName(), facilityRequest.getType(), facilityRequest.getImage_url(),calendar.calendarId);
                    System.out.println("Inserting Facility: "+ facility);
//                    calendarRepository.insert(calendar1);
                    facilityRepository.insert(facility);
                });
    }

    public List<Facility> getAllFacilities(){
        return facilityRepository.findAll();
    }
    public String getCalIdByName(String name){
        Optional<Facility> facility1= facilityRepository.findFacilityByName(name);
        Facility facility= facility1.orElseThrow();
        return facility.calendarId;
    }


    public void updateFacility(Facility facility) {
        String name1=facility.name;
        facilityRepository.findFacilityByName(name1)
                .ifPresentOrElse(f->{
                    f=facility;
                },()->{
                    System.out.println("Facility not present, So creating a new Facility");
                    facilityRepository.insert(facility);
                });
    }

    public void deleteFacility(Facility facility) {
        facilityRepository.delete(facility);
    }
}
