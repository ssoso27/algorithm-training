package com.example.smoothie.service;

import com.example.smoothie.entity.User;
import com.example.smoothie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> list() {
        return repository.findAll();
    }

    public User get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void create(User user) {
        repository.save(user);
    }

    public void update(User user) {
        repository.save(user);
    }

    public void delete(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
