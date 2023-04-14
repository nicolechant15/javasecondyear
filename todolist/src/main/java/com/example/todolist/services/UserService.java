package com.example.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.models.User;
import com.example.todolist.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public User update(User oldUser, User newUser) {

        oldUser.setFirstName(newUser.getFirstName());
        oldUser.setMiddleName(newUser.getMiddleName());
        oldUser.setLastName(newUser.getLastName());
        oldUser.setLogin(newUser.getLogin());
        oldUser.setBirthday(newUser.getBirthday());
        oldUser.setTasks(newUser.getTasks());
        oldUser.setChangedDateTime(newUser.getCreatedDateTime());
        userRepository.save(oldUser);
        return oldUser;
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

}