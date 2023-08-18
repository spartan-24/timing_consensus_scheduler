package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
//@AllArgsConstructor
public class User {
    @Id
    String userId;
    String email;
    String password;
    String name;
    String role; //Change this according to need, we need to automatically assign a role or give option between stu and fac
    //    boolean isAdmin;
//    boolean isOperator;
    String calendarId;

    public User(){

    }

    public User(String email, String password, String name, String role, String calendarId) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.calendarId = calendarId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", calendarId='" + calendarId + '\'' +
                '}';
    }
}
