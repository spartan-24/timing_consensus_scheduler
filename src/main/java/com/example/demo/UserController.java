package com.example.demo;

import com.example.demo.dto.AuthenticationRequest;
import com.example.demo.dto.SlotRequest;
import com.example.demo.dto.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping//C
    public void addUserFromJson(@RequestBody UserRequest userRequest) throws IOException {
        userService.addUser(userRequest);
    }

    @GetMapping//R
    public List<User> fetchAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping//U
    public void updateUser(User user){
        userService.updateUser(user);
    }

    @DeleteMapping//D
    public void deleteUser(User user){
        userService.deleteUser(user);
    }

    @GetMapping("/getCalendarId/byUserName")
    public String fetchUserByEmail(@RequestBody UserRequest userRequest){
//        return ResponseEntity.ok("done");
        return userService.getCalendarIdByEmail(userRequest.getEmail()).calendarId;
    }
    @GetMapping("/freeSlots")
    public ArrayList<Integer> fetchFreeSlotsOfDay(@RequestBody SlotRequest slotRequest){
        return userService.fetchFreeSlotsOfDay(slotRequest);
    }
    @PostMapping("/login")
    public void loginUser(@RequestBody AuthenticationRequest loginRequest) throws IOException {
        userService.loginUser(loginRequest);
    }


}
