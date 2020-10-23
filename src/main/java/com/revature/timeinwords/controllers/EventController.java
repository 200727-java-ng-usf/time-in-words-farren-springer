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
public class EventController {

    @Autowired
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // TODO save operation

    /**
     * READ operations
     */

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();

    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Event getEventById(@PathVariable int id) {

        if (id <= 0) {

            throw new InvalidRequestException("ID cannot be less than or equal to zero!");

        }

        Event event =  eventService.getEventById(id);

        return event;
    }

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EventDto getEventByName(@PathVariable String name) {

        if (name == null || name == "") {

            throw new InvalidRequestException("Event name cannot be null or empty!");

        }

        EventDto eventDto = eventService.getEventByName(name);

        return eventDto;

    }

    @GetMapping(value = "/timeinwords/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String timeInWords(@PathVariable int id) { // TODO event or eventDto? See how frontend works
        Event event = eventService.getEventById(id);
        int h = event.getH();
        int m = event.getM();
        return eventService.timeInWords(h, m);

    }

    @GetMapping(value = "/timeinwordscustom/hour/{hour}/minute/{minute}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String timeInWordsCustom(@PathVariable int hour, @PathVariable int minute) {
        return eventService.timeInWords(hour, minute);
    }


}
