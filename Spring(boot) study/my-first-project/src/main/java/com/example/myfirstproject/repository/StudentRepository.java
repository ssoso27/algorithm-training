package com.example.myfirstproject.repository;

import com.example.myfirstproject.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> { // 기본 crud 내장된 repo 생성
}
