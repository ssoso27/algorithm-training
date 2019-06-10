package com.example.smoothie.controller;

import com.example.smoothie.entity.Comment;
import com.example.smoothie.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService service;

    @GetMapping
    public List<Comment> list() {
        return service.list();
    }

}
