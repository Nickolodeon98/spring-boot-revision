package com.example.revision.controller;

import com.example.revision.dao.UserDao;
import com.example.revision.domain.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/user")
    public void addUser(@RequestBody UserDto user) {
        userDao.add(user);
    }

    @DeleteMapping("/blank/{toDelete}")
    public void deleteSelectedUser(@PathVariable("toDelete") String userId) {
        userDao.deleteUser(userId);
    }

    @DeleteMapping("/all-blank")
    public void deleteAllUsers() {
        userDao.deleteAll();
    }

}
