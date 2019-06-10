package com.example.smoothie.service;

import com.example.smoothie.entity.Comment;
import com.example.smoothie.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository repository;

    public List<Comment> list() {
        return repository.findAll();
    }
}
