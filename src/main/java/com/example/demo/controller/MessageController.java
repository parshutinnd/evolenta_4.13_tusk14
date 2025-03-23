package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Message;

@RestController
public class MessageController {
    private final List<Message> messages = new ArrayList<>();

    @GetMapping("/message")
    public List<Message> getMessage() {
        return this.messages;
    }

    @GetMapping("/message/{id}")
    public Optional<Message> getMessagebyId(@PathVariable int id) {
        return messages.stream().filter(m -> m.getId() == id).findFirst();
    }


    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        this.messages.add(message);
        return message;
    }

    @PutMapping("/message/{id}")
    public Message updateMessage(@PathVariable int id, @RequestBody Message message) {
        int index = - 1;
        for (Message m : messages) {
            if (m.getId() == id) {
                index = messages.indexOf(m);
                messages.set(index, message);
            }
        }
        return index == -1 ? addMessage(message) : message;
    }
}
