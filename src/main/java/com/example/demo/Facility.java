package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Facility {
    @Id
    String facilityId;
    @Indexed(unique = true)
    String name;
    String type;
    String image_url;
    String calendarId;

    public Facility(String name, String type, String image_url, String calendarId) {
        this.name = name;
        this.type = type;
        this.image_url = image_url;
        this.calendarId = calendarId;
    }
}
