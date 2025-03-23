package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private int id;
    private String title;
    private String text;
    private LocalDateTime time;
    
    public Message(int id, String title, String text){
        this.id = id;
        this.title = title;
        this.text = text;
        this.time = LocalDateTime.now();
    }
}
