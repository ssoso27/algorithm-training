package com.example.myfirstproject.repository;

import com.example.myfirstproject.entity.Lecture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends CrudRepository<Lecture, Integer> {
}
