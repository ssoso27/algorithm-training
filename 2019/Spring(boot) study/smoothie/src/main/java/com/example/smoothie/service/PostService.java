package com.example.smoothie.service;

import com.example.smoothie.dto.SimpleCommentDTO;
import com.example.smoothie.entity.Comment;
import com.example.smoothie.entity.Post;
import com.example.smoothie.repository.CommentRepository;
import com.example.smoothie.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository repository;

    @Autowired
    CommentRepository commentRepository;

    public List<Post> list() {
        return repository.findAll();
    }

    public Post get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void create(Post post) {
        repository.save(post);
    }

    public void update(Post post) {
        repository.save(post);
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    public List<SimpleCommentDTO> findComments(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        List<SimpleCommentDTO> results = new ArrayList<SimpleCommentDTO>();

        for (Comment comment: comments) {
            SimpleCommentDTO dto = new SimpleCommentDTO();
            dto.setId(comment.getId());
            dto.setPost_id(comment.getPost().getId());
            dto.setContent(comment.getContent());

            results.add(dto);
        }

        return results;
    }
}
