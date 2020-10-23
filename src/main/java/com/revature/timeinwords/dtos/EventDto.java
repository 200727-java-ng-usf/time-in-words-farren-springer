package com.revature.lastdayproject.dtos;

import java.util.Objects;

public class AppUserDto {

    private int id;
    private String name;

    public AppUserDto(com.revature.lastdayproject.entities.Event event) {
        this.id = event.getId();
        this.name = event.getName();
    }

    public AppUserDto() {
        super();
    }

    public AppUserDto(int id, String name) {
        this.id = id;
        this.name = name;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserDto that = (AppUserDto) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "AppUserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
