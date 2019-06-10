package com.example.smoothie.controller;

import com.example.smoothie.dto.SimpleCommentDTO;
import com.example.smoothie.entity.Comment;
import com.example.smoothie.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Comment get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PostMapping
    public void create(@RequestBody SimpleCommentDTO commentDTO) {
        service.create(commentDTO);
    }

    @PutMapping
    public void update(@RequestBody SimpleCommentDTO commentDTO) {
        service.update(commentDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
