package com.revature.timeinwords.services;

import com.revature.timeinwords.dtos.EventDto;
import com.revature.timeinwords.entities.Event;
import com.revature.timeinwords.repositories.EventRepository;
import com.revature.timeinwords.exceptions.InvalidRequestException;
import com.revature.timeinwords.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository repo) { this.eventRepository = repo; }


    // TODO save method
    /**
     * CREATE operation
     */
    @Transactional
    public void save(Event event) {
        eventRepository.save(event);
    }

    /**
     * getall method: Returns a list of all the appUser objects in the database.
     *
     * @return a list of all the appUsers
     * @throws ResourceNotFoundException when no appUsers are found
     */
    @Transactional(readOnly = true)
    public List<EventDto> getAllEvents(){

        Iterable<Event> iterable = eventRepository.findAll();
        List<Event> events = getListFromIterator(iterable);
        if(events.isEmpty()){
            throw new ResourceNotFoundException();
        }
        List<EventDto> eventDtos = new ArrayList<>();
        for(Event event : events){
            eventDtos.add(new EventDto(event));
        }
        return eventDtos;

    }

    /**
     * getUserById method: Returns an appUser object when the id int matches a record in the database.
     *
     * @param id appUserId int value
     * @return an appUser with matching id
     * @throws ResourceNotFoundException when an appUser is not found
     */
    @Transactional(readOnly = true)
    public Event getEventById(int id) {

        if(id <= 0) {
            throw new InvalidRequestException("Id number must be 1 or greater");
        }
        Event retrievedEvent = eventRepository.findById(id);
        if(retrievedEvent == null){
            throw new ResourceNotFoundException("No event with id: " + id + " was found");
        }
        return retrievedEvent;

    }

    /**
     * READ operation. Find Event by matching name field and return EventDto object.
     *
     * @param name
     * @return
     */
    @Transactional(readOnly = true)
    public EventDto getEventByName(String name) {

        if (name == null || name == "") {
            throw new InvalidRequestException("Event name cannot be null or empty!");
        }
        Event retrievedEvent = eventRepository.findByName(name);
        if (retrievedEvent == null) {
            throw new ResourceNotFoundException("No event found with name: " + name);
        }

        return new EventDto(retrievedEvent);

    }

    /**
     * DELETE operation
     *
     * Finds the event in the database and deletes the row.
     *
     * @param eventDto
     * @return
     */
    @Transactional
    public boolean delete(EventDto eventDto) {
        // find representation of event object in db by using dto's id
        Event eventToDelete = eventRepository.findById(eventDto.getId());
        // delete the event in the db
        eventRepository.delete(eventToDelete);
        return true;
    }


    /**
     * Convenience method
     *
     * getListFromIterator method: Changes an iterator to a list object
     *
     * @param iterable Iterable retrieved from repository
     * @return List of stated type
     */

    public static <T> List<T> getListFromIterator(Iterable<T> iterable) {

        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;

    }

    /**
     * MVP timeInWords method: takes in minte and hour, returns string of time
     */
    @Transactional
    public String timeInWords(int h, int m) {

        String hourWord;
        String minuteWord;
        String minuteWord2;
        int mUntil;
        int hUntil;
        String hourUntil;
        String result;

        if (m < 31) {
            switch(m) {
                case 0: minuteWord = "";
                    break;
                case 1: minuteWord = "one";
                    break;
                case 2: minuteWord = "two";
                    break;
                case 3: minuteWord = "three";
                    break;
                case 4: minuteWord = "four";
                    break;
                case 5: minuteWord = "five";
                    break;
                case 6: minuteWord = "six";
                    break;
                case 7: minuteWord = "seven";
                    break;
                case 8: minuteWord = "eight";
                    break;
                case 9: minuteWord = "nine";
                    break;
                case 10: minuteWord = "ten";
                    break;
                case 11: minuteWord = "eleven";
                    break;
                case 12: minuteWord = "twelve";
                    break;
                case 13: minuteWord = "thirteen";
                    break;
                case 14: minuteWord = "fourteen";
                    break;
                case 15: minuteWord = "quarter";
                    break;
                case 16: minuteWord = "sixteen";
                    break;
                case 17: minuteWord = "seventeen";
                    break;
                case 18: minuteWord = "eighteen";
                    break;
                case 19: minuteWord = "nineteen";
                    break;
                case 20: minuteWord = "twenty";
                    break;
                case 21: minuteWord = "twenty one";
                    break;
                case 22: minuteWord = "twenty two";
                    break;
                case 23: minuteWord = "twenty three";
                    break;
                case 24: minuteWord = "twentry four";
                    break;
                case 25: minuteWord = "twenty five";
                    break;
                case 26: minuteWord = "twenty six";
                    break;
                case 27: minuteWord = "twenty seven";
                    break;
                case 28: minuteWord = "twenty eight";
                    break;
                case 29: minuteWord = "twenty nine";
                    break;
                case 30: minuteWord = "half";
                    break;
                default: minuteWord = "invalid";
            }
            switch (h) {
                case 1: hourWord = "one";
                    break;
                case 2: hourWord = "two";
                    break;
                case 3: hourWord = "three";
                    break;
                case 4: hourWord = "four";
                    break;
                case 5: hourWord = "five";
                    break;
                case 6: hourWord = "six";
                    break;
                case 7: hourWord = "seven";
                    break;
                case 8: hourWord = "eight";
                    break;
                case 9: hourWord = "nine";
                    break;
                case 10: hourWord = "ten";
                    break;
                case 11: hourWord = "eleven";
                    break;
                case 12: hourWord = "twelve";
                    break;
                default: hourWord = "invalid";
            }
            if (m == 0) {
                result = hourWord + " o' clock";
            } else if (m == 30) {
                result = minuteWord + " past " + hourWord;
            } else if (m == 1) {
                result = minuteWord + " minute past " + hourWord;
            } else if (m != 15) {
                result = minuteWord + " minutes past " + hourWord;
            } else {
                result = minuteWord + " past " + hourWord;
            }

            return result;

        }
        if (m > 30) {

            mUntil = 60 - m;
            hUntil = h + 1;

            switch(mUntil) {
                case 1: minuteWord = "one";
                    break;
                case 2: minuteWord = "two";
                    break;
                case 3: minuteWord = "three";
                    break;
                case 4: minuteWord = "four";
                    break;
                case 5: minuteWord = "five";
                    break;
                case 6: minuteWord = "six";
                    break;
                case 7: minuteWord = "seven";
                    break;
                case 8: minuteWord = "eight";
                    break;
                case 9: minuteWord = "nine";
                    break;
                case 10: minuteWord = "ten";
                    break;
                case 11: minuteWord = "eleven";
                    break;
                case 12: minuteWord = "twelve";
                    break;
                case 13: minuteWord = "thirteen";
                    break;
                case 14: minuteWord = "fourteen";
                    break;
                case 15: minuteWord = "quarter";
                    break;
                case 16: minuteWord = "sixteen";
                    break;
                case 17: minuteWord = "seventeen";
                    break;
                case 18: minuteWord = "eighteen";
                    break;
                case 19: minuteWord = "nineteen";
                    break;
                case 20: minuteWord = "twenty";
                    break;
                case 21: minuteWord = "twenty one";
                    break;
                case 22: minuteWord = "twenty two";
                    break;
                case 23: minuteWord = "twenty three";
                    break;
                case 24: minuteWord = "twentry four";
                    break;
                case 25: minuteWord = "twenty five";
                    break;
                case 26: minuteWord = "twenty six";
                    break;
                case 27: minuteWord = "twenty seven";
                    break;
                case 28: minuteWord = "twenty eight";
                    break;
                case 29: minuteWord = "twenty nine";
                    break;
                case 30: minuteWord = "thirty";
                    break;
                default: minuteWord = "invalid";
            }
            switch (hUntil) {
                case 2: hourWord = "two";
                    break;
                case 3: hourWord = "three";
                    break;
                case 4: hourWord = "four";
                    break;
                case 5: hourWord = "five";
                    break;
                case 6: hourWord = "six";
                    break;
                case 7: hourWord = "seven";
                    break;
                case 8: hourWord = "eight";
                    break;
                case 9: hourWord = "nine";
                    break;
                case 10: hourWord = "ten";
                    break;
                case 11: hourWord = "eleven";
                    break;
                case 12: hourWord = "twelve";
                    break;
                case 13: hourWord = "one";
                    break;
                default: hourWord = "invalid";
            }
            if (mUntil != 15) {
                result = minuteWord + " minutes to " + hourWord;
            } else if (mUntil == 1) {
                result = minuteWord + " minute to " + hourWord;
            } else if (mUntil == 15) {
                result = minuteWord + " to " + hourWord;
            } else {
                result = minuteWord + " to " + hourWord;
            }
            return result;

        }
        else {
            result = "invalid";
            return result;
        }

    }


}
