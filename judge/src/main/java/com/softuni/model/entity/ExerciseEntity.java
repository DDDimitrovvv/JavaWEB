package com.softuni.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "exercises")
public class ExerciseEntity extends BaseEntity{

    private String name;
    private LocalDateTime startedOn;
    private LocalDateTime dueDate;

    public ExerciseEntity() {
    }

    @Column(name = "name", unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public ExerciseEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "started_on", nullable = false)
    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public ExerciseEntity setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
        return this;
    }

    @Column(name = "due_date", nullable = false)
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public ExerciseEntity setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
