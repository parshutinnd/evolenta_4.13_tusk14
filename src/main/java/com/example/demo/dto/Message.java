package com.example.demo.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue
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
