package ru.dns.vitrina.server.storage.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.dns.vitrina.server.model.User;
import ru.dns.vitrina.server.storage.BaseRepository;
import ru.dns.vitrina.server.storage.inheritance.UserRepository;


import java.util.*;

@Repository
public class UserRepositoryImpl extends BaseRepository<User> implements UserRepository {
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM users WHERE id = ?";
    private static final String FIND_BY_SIGN_QUERY = "SELECT * FROM users WHERE last_name = ? AND password = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM users";
    private static final String INSERT_QUERY = "INSERT INTO users(name,last_name,password,root) VALUES(?, ?, ?, ?)";
    private static final String INSERT_COLOR_QUERY = "INSERT INTO color_user(color_id, user_id) VALUES(?, ?)";
    private static final String INSERT_ANIMAL_QUERY = "INSERT INTO animal_user(animal_id, user_id) VALUES(?, ?)";
    private static final String UPDATE_QUERY = "UPDATE users SET name = ?, last_name = ?, password = ?, root = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM users WHERE id = ?";
    private static final String DELETE_COLOR_QUERY = "DELETE FROM color_user WHERE user_id = ?";
    private static final String DELETE_ANIMAL_QUERY = "DELETE FROM animal_user WHERE user_id = ?";

    public UserRepositoryImpl(JdbcTemplate jdbc, RowMapper<User> mapper) {
        super(jdbc, mapper);
    }

    @Override
    public User save(User user) {
        long id = insert(
                INSERT_QUERY,
                user.getName(),
                user.getLastName(),
                user.getPassword(),
                user.isRoot()
        );
        user.setId(id);
        return user;
    }

    @Override
    public User update(User user) {
        update(
                UPDATE_QUERY,
                user.getName(),
                user.getLastName(),
                user.getPassword(),
                user.isRoot()
        );
        return user;
    }

    @Override
    public boolean delete(long id) {
        delete(DELETE_QUERY, id);
        return false;
    }

    @Override
    public User getUserSign(String lastName, String password) {
        return jdbc.queryForObject(FIND_BY_SIGN_QUERY, mapper, lastName, password);
    }

    @Override
    public Optional<User> findById(long id) {
        return findOne(FIND_BY_ID_QUERY, id);
    }

    @Override
    public List<User> getAll() {
        return findMany(FIND_ALL_QUERY);
    }

    @Override
    public void saveColor(long colorId, long userId) {
        insert(
                INSERT_COLOR_QUERY,
                colorId,
                userId
        );
    }

    @Override
    public void saveAnimal(long animalId, long userId) {
        insert(
                INSERT_ANIMAL_QUERY,
                animalId,
                userId
        );
    }

    @Override
    public boolean deleteColor(long userId) {
        return delete(DELETE_COLOR_QUERY, userId);
    }

    @Override
    public boolean deleteAnimal(long userId) {
        return delete(DELETE_ANIMAL_QUERY, userId);
    }
}
