package com.example.myfirstproject.repository;

import com.example.myfirstproject.entity.Lecture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends CrudRepository<Lecture, Integer> {
    @Query(value = "select * from lectures l join attended_lectures a on l.id=a.lecture_id where a.student_id = ?1", nativeQuery = true)
    List<Lecture> findAllByStuentId(Integer studnet_id);
}
