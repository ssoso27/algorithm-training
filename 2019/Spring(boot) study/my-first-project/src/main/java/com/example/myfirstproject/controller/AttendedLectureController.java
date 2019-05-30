package com.example.myfirstproject.controller;

import com.example.myfirstproject.entity.AttendedLecture;
import com.example.myfirstproject.entity.Lecture;
import com.example.myfirstproject.service.AttendedLectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attended-lecture")
public class AttendedLectureController {
    @Autowired
    private AttendedLectureService service;

    @GetMapping
    public List<AttendedLecture> list() {
        return service.list();
    }

    @PostMapping
    public void create(@RequestBody AttendedLecture attendedLecture) {
        service.create(attendedLecture);
    }

    @PutMapping
    public void update(@RequestBody AttendedLecture attendedLecture) {
        service.update(attendedLecture);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
