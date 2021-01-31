package com.softuni.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "homeworks")
public class HomeworkEntity extends BaseEntity{

    private LocalDateTime addedOn;
    private String gitAddress;
    private UserEntity author;
    private ExerciseEntity exercise;

    public HomeworkEntity() {
    }

    @Column(name = "added_on")
    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public HomeworkEntity setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    @Column(name = "git_address", nullable = false)
    public String getGitAddress() {
        return gitAddress;
    }

    public HomeworkEntity setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
        return this;
    }

    @ManyToOne
    public UserEntity getAuthor() {
        return author;
    }

    public HomeworkEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    @ManyToOne
    public ExerciseEntity getExercise() {
        return exercise;
    }

    public HomeworkEntity setExercise(ExerciseEntity exercise) {
        this.exercise = exercise;
        return this;
    }
}
