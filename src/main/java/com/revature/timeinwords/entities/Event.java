package com.revature.timeinwords.entities;

import com.revature.timeinwords.dtos.EventDto;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Event implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String location;


    @Column
    private String date;

    @Column
    private int h; // hour. Naming so it is compatible with hackerrank method.

    @Column
    private int m; // minute. Naming so it is compatible with hackerrank method.

    public Event() {
        super();
    }

    public Event(String name, String location, String date, int h, int m) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.h = h;
        this.m = m;
    }

    public Event(int id, String name, String location, String date, int h, int m) {
        this(name, location, date, h, m);
        this.id = id;
    }

    public Event(EventDto eventDto) {
        this.name = eventDto.getName();
        this.location = eventDto.getLocation();
        this.date = eventDto.getDate();
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

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                h == event.h &&
                m == event.m &&
                Objects.equals(name, event.name) &&
                Objects.equals(location, event.location) &&
                Objects.equals(date, event.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, date, h, m);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", h=" + h +
                ", m=" + m +
                '}';
    }
}
