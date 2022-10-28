package com.example.revision.dao;

import com.example.revision.domain.dto.UserDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void deleteAll() {
        this.jdbcTemplate.update("DELETE FROM users");
    }

    public void add(UserDto user) {
        this.jdbcTemplate.update("INSERT INTO users VALUES (?, ?, ?)", user.getId(), user.getName(), user.getPassword());
    }
}
