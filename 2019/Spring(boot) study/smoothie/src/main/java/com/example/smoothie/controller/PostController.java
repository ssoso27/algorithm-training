package com.example.smoothie.controller;

import com.example.smoothie.entity.Post;
import com.example.smoothie.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService service;

    @GetMapping
    public List<Post> list() {
        return service.list();
    }
}
