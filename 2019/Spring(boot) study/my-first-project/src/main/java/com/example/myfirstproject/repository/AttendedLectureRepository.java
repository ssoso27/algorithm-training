package com.example.myfirstproject.repository;

import com.example.myfirstproject.entity.AttendedLecture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendedLectureRepository extends CrudRepository<AttendedLecture, Integer> {
}
