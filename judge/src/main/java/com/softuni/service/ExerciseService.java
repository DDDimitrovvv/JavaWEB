package com.softuni.service;

import com.softuni.model.entity.ExerciseEntity;
import com.softuni.model.service.ExerciseEntityServiceModel;

import java.util.List;

public interface ExerciseService {
    void addExercise(ExerciseEntityServiceModel exerciseEntityServiceModel);

    List<String> findAllExNames();

    boolean checkIsLate(String exercise);

    ExerciseEntity findByName(String name);
}
