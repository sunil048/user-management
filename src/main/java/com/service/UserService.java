package com.service;

import java.util.List;

import com.model.User;


public interface UserService {
    void save(User user);
    User findByUsername(String username);
    User findUserById(Long userId);
    List <User> getAllUsers();
    boolean upadateRolesForUser(Long userId,String roles[]);
    
}