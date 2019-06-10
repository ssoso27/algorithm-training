package com.example.smoothie.service;

import com.example.smoothie.entity.Post;
import com.example.smoothie.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository repository;

    public List<Post> list() {
        return repository.findAll();
    }
}
