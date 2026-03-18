package com.springbootpractice.services;

import com.springbootpractice.model.User;

import java.util.List;

public interface UserService {

    public User addNewUser(User user);

    public User deleteUser(Long userId);

    public User UpdateUserNameAndPassword(Long userId , String userName , String password);

    public User getUserByUserId(Long userId);

    public List<User> getAllUser();
}
