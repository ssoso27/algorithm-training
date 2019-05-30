package com.example.myfirstproject.service;

import com.example.myfirstproject.entity.Lecture;
import com.example.myfirstproject.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService {
    @Autowired
    private LectureRepository repository;

    public List<Lecture> list() {
        return (List<Lecture>) repository.findAll();
    }

    public void create(Lecture lecture) {
        repository.save(lecture);
    }

    public void update(Lecture lecture) {
        repository.save(lecture);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
