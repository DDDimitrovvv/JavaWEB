package com.softuni.model.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class HomeworkEntityAddBindingModel {

    private String exercise;
    private String gitAddress;

    public HomeworkEntityAddBindingModel() {
    }

    @Size(min = 2)
    public String getExercise() {
        return exercise;
    }

    public HomeworkEntityAddBindingModel setExercise(String exercise) {
        this.exercise = exercise;
        return this;
    }

    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+",
            message = "Please enter valid git address!")
    @NotNull
    public String getGitAddress() {
        return gitAddress;
    }

    public HomeworkEntityAddBindingModel setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
        return this;
    }
}
