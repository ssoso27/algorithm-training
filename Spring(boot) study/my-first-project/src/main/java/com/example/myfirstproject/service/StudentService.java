package com.example.myfirstproject.service;

import com.example.myfirstproject.model.Student;
import com.example.myfirstproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void create(Student student) {
        studentRepository.save(student);
    }

    public List<Student> list() {
        return (List<Student>) studentRepository.findAll();
    }

    public Student get(Integer id) {
        // TODO : 에러핸들링 해주기
        return studentRepository.findById(id).get();
    }
}
