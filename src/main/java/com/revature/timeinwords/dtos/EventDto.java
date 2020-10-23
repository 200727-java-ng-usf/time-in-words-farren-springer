package com.revature.timeinwords.dtos;

import com.revature.timeinwords.entities.Event;

import java.util.Objects;

public class EventDto {

    private int id;
    private String name;
    private String location;
    private String date;
    private String hourWord;
    private String minuteWord;

    public EventDto() {
        super();
    }

    public EventDto(String name, String location, String date, String hourWord, String minuteWord) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.hourWord = hourWord;
        this.minuteWord = minuteWord;
    }

    public EventDto(int id, String name, String location, String date, String hourWord, String minuteWord) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
        this.hourWord = hourWord;
        this.minuteWord = minuteWord;
    }

    public EventDto(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.location = event.getLocation();
        this.date = event.getDate();
        // TODO implement hackerrank function to take in an event and return an eventDTO with
        // TODO word representations of the hours and minutes
        this.hourWord = "not implemented yet";
        this.minuteWord = "not implemented yet";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHourWord() {
        return hourWord;
    }

    public void setHourWord(String hourWord) {
        this.hourWord = hourWord;
    }

    public String getMinuteWord() {
        return minuteWord;
    }

    public void setMinuteWord(String minuteWord) {
        this.minuteWord = minuteWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDto eventDto = (EventDto) o;
        return id == eventDto.id &&
                Objects.equals(name, eventDto.name) &&
                Objects.equals(location, eventDto.location) &&
                Objects.equals(date, eventDto.date) &&
                Objects.equals(hourWord, eventDto.hourWord) &&
                Objects.equals(minuteWord, eventDto.minuteWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, date, hourWord, minuteWord);
    }

    @Override
    public String toString() {
        return "EventDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", hourWord='" + hourWord + '\'' +
                ", minuteWord='" + minuteWord + '\'' +
                '}';
    }
}
