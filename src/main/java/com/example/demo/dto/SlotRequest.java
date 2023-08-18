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
public class SlotRequest {
    LocalDate date;
    ArrayList<String> bookedByUsers;
    String bookedToType;
    String bookedToUser;

}
