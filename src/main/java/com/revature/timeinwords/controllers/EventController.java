package com.revature.timeinwords.controllers;
import com.revature.timeinwords.dtos.EventDto;
import com.revature.timeinwords.entities.Event;
import com.revature.timeinwords.exceptions.InvalidRequestException;
import com.revature.timeinwords.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class AppUserController {

    @Autowired
    private EventService eventService;

    public AppUserController(EventService eventService) {
        this.eventService = eventService;
    }

    /**
     * CREATE operations
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Event save(@RequestBody EventDto eventDto) {

        if (eventDto == null) {

            throw new InvalidRequestException("Event cannot be null!");

        }

        return eventService.save(eventDto);

    }
    /**
     * READ operations
     */

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();

    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EventDto getEventById(@PathVariable int id) {

        if (id <= 0) {

            throw new InvalidRequestException("ID cannot be less than or equal to zero!");

        }

        EventDto eventDto =  eventService.getEventById(id);

        return eventDto;
    }

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EventDto getEventByName(@PathVariable String name) {

        if (name == null || name == "") {

            throw new InvalidRequestException("Event name cannot be null or empty!");

        }

        EventDto eventDto = eventService.getEventByName(name);

        return eventDto;

    }

}
