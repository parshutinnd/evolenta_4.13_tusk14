package com.example.demo.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Message;
import com.example.demo.repository.MessageRepository;


@RestController
public class MessageController {
    private MessageRepository repository;

    @GetMapping("/message")
    public Iterable<Message> getMessage() {
        return repository.findAll();
    }

    @GetMapping("/message/{id}")
    public Optional<Message> getMessagebyId(@PathVariable int id) {
        return repository.findById(id);
    }


    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        repository.save(message);
        return message;
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
        HttpStatus status = repository.existsById(id) ? HttpStatus.OK : HttpStatus.CREATED;
        message.setId(id);
        return new ResponseEntity(repository.save(message), status);
    }

     @DeleteMapping("/message/{id}")
    public void deletePerson(@PathVariable int id) {
        repository.deleteById(id);
    }
}
