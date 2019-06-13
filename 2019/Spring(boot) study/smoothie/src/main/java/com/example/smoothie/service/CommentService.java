package com.example.smoothie.service;

import com.example.smoothie.dto.SimpleCommentDTO;
import com.example.smoothie.entity.Comment;
import com.example.smoothie.entity.Post;
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

    public Comment get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void create(SimpleCommentDTO commentDTO) {
        repository.simpleSave(commentDTO.getPost_id(), commentDTO.getContent());
    }

    public void update(SimpleCommentDTO commentDTO) {
        repository.simpleUpdate(commentDTO.getId(), commentDTO.getContent());
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
