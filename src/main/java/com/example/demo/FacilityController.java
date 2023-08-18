package com.example.demo;

import com.example.demo.dto.FacilityRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/facilities")
@AllArgsConstructor
public class FacilityController {
    private final FacilityService facilityService;

    @PostMapping//C
    public void addFacilityFromJson(@RequestBody FacilityRequest facilityRequest){
        facilityService.addFacility(facilityRequest);
    }

    @GetMapping//R
    public List<Facility> fetchAllFacilities(){
        return facilityService.getAllFacilities();
    }
//    @GetMapping("/byName")
//    public String fetchCalIdByName(String name){
//        return
//    }
    @PutMapping//U
    public void updateFacility(Facility facility){
        facilityService.updateFacility(facility);
    }

    @DeleteMapping//D
    public void deleteFacility(Facility facility){
        facilityService.deleteFacility(facility);
    }
}
