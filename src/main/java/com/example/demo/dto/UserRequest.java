package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {
    String email;
    String password;
    String name;
    String role; //Change this according to need, we need to automatically assign a role or give option between stu and fac
}
