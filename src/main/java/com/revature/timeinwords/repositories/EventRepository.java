package com.revature.timeinwords.repositories;

import com.revature.timeinwords.entities.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {


    // CREATE
    Event save(Event event);

    // READ
    Event findById(int id);

    Event findByName(String name);

    List<Event> findAll();

    // UPDATE


    // DELETE

}
