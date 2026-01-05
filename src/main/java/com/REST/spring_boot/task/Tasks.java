package com.REST.spring_boot.task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.ZonedDateTime;
import java.util.Objects;

// Entity class representing a Task
@Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Boolean active;
    private ZonedDateTime dueDate;

    public Tasks() {
    }

    public Tasks(ZonedDateTime dueDate,
                 Boolean active,
                 String description,
                 String name,
                 Integer id) {
        this.dueDate = dueDate;
        this.active = active;
        this.description = description;
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ZonedDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(ZonedDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tasks tasks = (Tasks) o;
        return Objects.equals(id, tasks.id) && Objects.equals(name, tasks.name) && Objects.equals(description, tasks.description) && Objects.equals(active, tasks.active) && Objects.equals(dueDate, tasks.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, active, dueDate);
    }
}
