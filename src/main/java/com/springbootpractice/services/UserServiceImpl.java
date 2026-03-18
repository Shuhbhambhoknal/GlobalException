package com.springbootpractice.services;

import com.springbootpractice.model.User;
import com.springbootpractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Long userId) {
        User existingUser = userRepository.findById(userId).orElse(null);

        if(existingUser != null){
            existingUser.setUserDeleted(true);
            userRepository.save(existingUser);
        }
        return existingUser;
    }

    @Override
    public User UpdateUserNameAndPassword(Long userId, String userName, String password) {
        User existingUser = userRepository.findById(userId).orElse(null);

        if(existingUser != null) {
            existingUser.setUserName(userName);
            existingUser.setPassword(password);
            return userRepository.save(existingUser);
        }

        return null;
    }

    @Override
    public User getUserByUserId(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

}

