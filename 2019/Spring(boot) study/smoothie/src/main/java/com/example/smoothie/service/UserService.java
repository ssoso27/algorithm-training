package com.example.smoothie.service;

import com.example.smoothie.dto.SimpleUserDTO;
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

    public void create(SimpleUserDTO user) {
        repository.simpleSave(user.getEmail(), user.getNickname(), user.getPassword(), user.getIntro());
    }

    public void update(SimpleUserDTO user) {
        repository.simpleUpdate(user.getId(), user.getEmail(), user.getNickname(), user.getPassword(), user.getIntro());
    }

    public void delete(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
