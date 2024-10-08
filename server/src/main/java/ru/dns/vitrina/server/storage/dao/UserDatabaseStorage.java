package ru.dns.vitrina.server.storage.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import ru.dns.vitrina.server.exception.NotFoundException;
import ru.dns.vitrina.server.model.User;
import ru.dns.vitrina.server.storage.inheritance.UserStorage;


import java.sql.PreparedStatement;
import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserDatabaseStorage implements UserStorage {
    private final JdbcTemplate jdbcTemplate;

    public User createUser(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sqlQuery = "INSERT INTO users (name, password, last_name,root) VALUES ( ?, ?, ?, ?)";
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(sqlQuery, new String[]{"id"});
                    ps.setString(1, user.getName());
                    ps.setString(2, user.getPassword());
                    ps.setString(3, user.getLastName());
                    ps.setBoolean(4, user.isRoot());
                    return ps;
                },
                keyHolder);
        user.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return getUser(user.getId());
    }

    @Override
    public User updateUser(User user) {
        String sqlQuery = "UPDATE users SET name = ?, password = ?, last_name = ?, root = ? WHERE id = ?";
        jdbcTemplate.update(sqlQuery, user.getName(), user.getPassword(), user.getLastName(),user.isRoot(), user.getId());
        return getUser(user.getId());
    }

    @Override
    public void deleteUser(long userId) {
        User user = getUser(userId);
        String sqlQuery = "DELETE FROM users WHERE id = ?;";
        jdbcTemplate.update(sqlQuery, userId);
    }

    @Override
    public User getUser(long userId) {
        String sqlQuery = "SELECT * FROM users WHERE id = ?";
        SqlRowSet userRows = jdbcTemplate.queryForRowSet(sqlQuery, userId);
        if (userRows.next()) {
            User user = User.builder()
                    .name(userRows.getString("name"))
                    .password(userRows.getString("password"))
                    .lastName(userRows.getString("last_name"))
                    .root(userRows.getBoolean("root"))
                    .id(userRows.getLong("id"))
                    .build();
            log.info("Найден пользователь с id {}", userId);
            return user;
        }
        throw new NotFoundException("Пользователь с id {} не найден" + userId);
    }

    @Override
    public User getUserSign(String lastName,String password) {
        String sqlQuery = "SELECT * FROM users WHERE last_name = ? AND password = ?";
        SqlRowSet userRows = jdbcTemplate.queryForRowSet(sqlQuery, lastName, password);
        if (userRows.next()) {
            User userSeach = User.builder()
                    .name(userRows.getString("name"))
                    .password(userRows.getString("password"))
                    .lastName(userRows.getString("last_name"))
                    .root(userRows.getBoolean("root"))
                    .id(userRows.getLong("id"))
                    .build();
            log.info("Найден пользователь с фамилией {}", lastName);
            return userSeach;
        }
        throw new NotFoundException("Пользователь с фамилией и паролем не найден " + lastName + " " + password);
    }

}
