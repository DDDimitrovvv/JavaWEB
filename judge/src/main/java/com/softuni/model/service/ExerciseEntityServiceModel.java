package com.softuni.model.service;

import java.time.LocalDateTime;

public class ExerciseEntityServiceModel {

    private Long id;
    private String name;
    private LocalDateTime startedOn;
    private LocalDateTime dueDate;

    public ExerciseEntityServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ExerciseEntityServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ExerciseEntityServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public ExerciseEntityServiceModel setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
        return this;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public ExerciseEntityServiceModel setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
