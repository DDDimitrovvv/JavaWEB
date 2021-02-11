package com.softuni.service.impl;

import com.softuni.model.entity.ExerciseEntity;
import com.softuni.model.service.ExerciseEntityServiceModel;
import com.softuni.repository.ExerciseRepository;
import com.softuni.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addExercise(ExerciseEntityServiceModel exerciseEntityServiceModel) {
        exerciseRepository.save(modelMapper
                .map(exerciseEntityServiceModel, ExerciseEntity.class));
    }

    @Override
    public List<String> findAllExNames() {
        return exerciseRepository.findAllExNames();
    }

    @Override
    public boolean checkIsLate(String exercise) {
        ExerciseEntity exerciseEntity = exerciseRepository
                .findByName(exercise)
                .orElse(null);

        return exerciseEntity.getDueDate().isBefore(LocalDateTime.now());
    }

    @Override
    public ExerciseEntity findByName(String name) {
        return exerciseRepository
                .findByName(name)
                .orElse(null);
    }
}
