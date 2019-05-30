package com.example.myfirstproject.service;

import com.example.myfirstproject.entity.Lecture;
import com.example.myfirstproject.entity.Student;
import com.example.myfirstproject.repository.LectureRepository;
import com.example.myfirstproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LectureRepository lectureRepository;

    public void create(Student student) {
        studentRepository.save(student);
    }

    public List<Student> list() {
        return (List<Student>) studentRepository.findAll();
    }

    public Student get(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void update(Student student) {
        studentRepository.save(student);
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    public List<Lecture> listAttndedLectures(Integer id) {
        return lectureRepository.findAllByStuentId(id);
    }
}
