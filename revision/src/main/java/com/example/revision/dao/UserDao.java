package com.example.revision.dao;

import com.example.revision.domain.User;
import com.example.revision.domain.dto.UserDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDao { // Data access object -> 나중에는 JPA 와 같은 ORM 로 대체된다.
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void deleteAll() {
        this.jdbcTemplate.update("DELETE FROM users");
    }

    public void deleteUser(String id) {
        this.jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    public int add(User user) {
        return this.jdbcTemplate.update("INSERT INTO users VALUES (?, ?, ?)", user.getId(), user.getName(), user.getPassword());
    }

    public User findById(String id) {
        return this.jdbcTemplate.queryForObject("SELECT id, name, password FROM users WHERE id = ?", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
                return user;
            }
        }, id);
    }
}
