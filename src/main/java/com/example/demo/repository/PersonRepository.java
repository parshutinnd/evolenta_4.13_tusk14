package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Person;
@Repository
public interface  PersonRepository extends  CrudRepository<Person, Integer>{

}
