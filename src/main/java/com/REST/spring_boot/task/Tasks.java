package com.REST.spring_boot.task;

import com.REST.spring_boot.authentication.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Objects;

// Entity class representing a Task
@Setter // This annotation generates setter methods for all fields in the class.
@Entity
@NoArgsConstructor // This annotation generates a no-argument constructor, so that JPA can create instances of this class.
@Table(name = "tasks")
public class Tasks {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Getter
    private String name;
    @Getter
    private String description;
    @Getter
    private Boolean active;
    @Getter
    private ZonedDateTime dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

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

    public void updateFrom(Tasks tasks) {
        this.name = tasks.getName();
        this.description = tasks.getDescription();
        this.active = tasks.getActive();
        this.dueDate = tasks.getDueDate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tasks tasks = (Tasks) o;
        return Objects.equals(id, tasks.id) &&
                Objects.equals(name, tasks.name) &&
                Objects.equals(description, tasks.description) &&
                Objects.equals(active, tasks.active) &&
                Objects.equals(dueDate, tasks.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, active, dueDate);
    }

}

