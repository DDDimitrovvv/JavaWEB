package com.softuni.repository;

import com.softuni.model.entity.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Long> {

    @Query(value = "SELECT e.name from judge_db.exercises as e ORDER BY e.name asc ", nativeQuery = true)
//    @Query("SELECT e.name FROM ExerciseEntity e " +
//    "ORDER BY e.name ASC")
    List<String> findAllExNames();

    Optional<ExerciseEntity> findByName(String name);
}
