package com.example.revision.controller;

import com.example.revision.dao.UserDao;
import com.example.revision.domain.User;
import com.example.revision.domain.dto.UserDto;
import io.swagger.models.Response;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3")
@Slf4j
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/user")
    public ResponseEntity<Integer> addUser(@RequestBody UserDto userDto) {
        log.info("User 를 데이터베이스에 추가합니다.");
        User user = new User(userDto.getId(), userDto.getName(), userDto.getPassword());
        return ResponseEntity.ok().body(userDao.add(user));
    }

    @DeleteMapping("/blank/{toDelete}")
    public void deleteSelectedUser(@PathVariable("toDelete") String userId) {
        log.info("User 를 데이터베이스에서 삭제합니다.");
        userDao.deleteUser(userId);
    }

    @DeleteMapping("/all-blank")
    public void deleteAllUsers() {
        log.info("User 테이블 내의 모든 항목을 삭제합니다.");
        userDao.deleteAll();
    }

    @GetMapping("/selection/{id}")
    public String findUser(@PathVariable String id) {
        log.info("User 테이블 내의 항목을 검색합니다.");
        User user = userDao.findById(id);
        return user.toString();
    }

}
