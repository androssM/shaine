package com.shane.interfaces;

import com.shane.entity.User;

import java.util.Optional;

public interface UserInterface {
    public User registerUser(String username,String password, String role);
    public Optional<User> findByUsername(String username);

}
