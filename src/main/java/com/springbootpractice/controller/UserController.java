package com.springbootpractice.controller;

import com.springbootpractice.model.User;
import com.springbootpractice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addNewUser(user));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Long userId) {
        User delete=userService.deleteUser(userId);
        return ResponseEntity.ok(delete);
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/updateUser/{userId}/{userName}/{password}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @PathVariable String userName, @PathVariable String password) {
        User updatedUser = userService.UpdateUserNameAndPassword(userId, userName, password);
        return ResponseEntity.ok(updatedUser);
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) throws Exception {
        User user=userService.getUserByUserId(userId);
        return ResponseEntity.ok(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/allUser")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUser=userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

}
