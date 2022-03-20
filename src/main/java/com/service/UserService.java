package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUser(Long id);
    User getUserById(Long id);
    void update(User user, int id);
}
