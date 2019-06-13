package com.example.smoothie.controller;

import com.example.smoothie.dto.SimpleUserDTO;
import com.example.smoothie.entity.User;
import com.example.smoothie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public List<User> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public void create(@RequestBody SimpleUserDTO simpleUserDTO) {
        service.create(simpleUserDTO);
    }

    @PutMapping
    public void update(@RequestBody SimpleUserDTO simpleUserDTO) {
        service.update(simpleUserDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
