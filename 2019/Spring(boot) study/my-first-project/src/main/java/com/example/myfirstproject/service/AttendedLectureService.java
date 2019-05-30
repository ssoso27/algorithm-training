package com.example.myfirstproject.service;

import com.example.myfirstproject.entity.AttendedLecture;
import com.example.myfirstproject.repository.AttendedLectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendedLectureService {
    @Autowired
    AttendedLectureRepository repository;

    public List<AttendedLecture> list() {
        return (List<AttendedLecture>) repository.findAll();
    }

    public void create(AttendedLecture attendedLecture) {
        repository.save(attendedLecture);
    }

    public void update(AttendedLecture attendedLecture) {
        repository.save(attendedLecture);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
