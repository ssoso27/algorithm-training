package com.example.smoothie.controller;

import com.example.smoothie.dto.SimpleCommentDTO;
import com.example.smoothie.entity.Comment;
import com.example.smoothie.entity.Post;
import com.example.smoothie.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Post get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public void create(@RequestBody Post post) {
        service.create(post);
    }

    @PutMapping
    public void update(@RequestBody Post post) {
        service.update(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}/comments")
    public List<SimpleCommentDTO> findComments(@PathVariable Long id) {
        return service.findComments(id);
    }
}
