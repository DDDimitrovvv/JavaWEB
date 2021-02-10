package com.softuni.model.binding;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class ExerciseEntityAddBindingModel {

    private String name;
    private LocalDateTime startedOn;
    private LocalDateTime dueDate;

    public ExerciseEntityAddBindingModel() {
    }

    @Size(min = 2, message = "The name must be minimum two characters.")
    public String getName() {
        return name;
    }

    public ExerciseEntityAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @PastOrPresent(message = "The date cannot be in the future.")
    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public ExerciseEntityAddBindingModel setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "The date cannot be in the past.")
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public ExerciseEntityAddBindingModel setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
