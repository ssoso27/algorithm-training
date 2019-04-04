package com.example.myfirstproject.service;

import com.example.myfirstproject.model.Student;
import com.example.myfirstproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void create(Student student) {
        studentRepository.save(student);
    }
}
