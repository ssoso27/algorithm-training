package com.example.myfirstproject.controller;

import com.example.myfirstproject.entity.Lecture;
import com.example.myfirstproject.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lectures")
public class LectureController {
    @Autowired
    private LectureService service;

    @GetMapping
    public List<Lecture> list() {
        return service.list();
    }

    @PostMapping
    public void create(@RequestBody Lecture lecture) {
        service.create(lecture);
    }

    @PutMapping
    public void update(@RequestBody Lecture lecture) {
        service.update(lecture);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
