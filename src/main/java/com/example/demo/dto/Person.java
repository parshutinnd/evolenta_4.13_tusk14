package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Person {
    private int id;
    private String firstname;
    private String surname;
    private String lastname;
    private LocalDate birthday;
}
