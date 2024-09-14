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
    private static final String INSERT_TASK_QUERY = "INSERT INTO tasks_user(tasks_id, user_id) VALUES(?, ?)";
    private static final String INSERT_BLOCK_QUERY = "INSERT INTO blocks_user(block_id, user_id) VALUES(?, ?)";
    private static final String UPDATE_QUERY = "UPDATE users SET name = ?, last_name = ?, password = ?, root = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM users WHERE id = ?";
    private static final String DELETE_TASK_QUERY = "DELETE FROM tasks_user WHERE user_id = ? AND tasks_id = ?";
    private static final String DELETE_ALL_TASKS_QUERY = "DELETE FROM tasks_user WHERE user_id = ?";
    private static final String DELETE_BLOCK_QUERY = "DELETE FROM blocks_user WHERE user_id = ? AND blocks_id = ?";
    private static final String DELETE_ALL_BLOCKS_QUERY = "DELETE FROM blocks_user WHERE user_id = ?";

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
    public void saveTask(long taskId, long userId) {
        insert(
                INSERT_TASK_QUERY,
                taskId,
                userId
        );
    }

    @Override
    public void deleteTask(long taskId, long userId) {
        jdbc.update(DELETE_TASK_QUERY, taskId, userId);
    }

    @Override
    public void saveBlock(long blockId, long userId) {
        insert(
                INSERT_BLOCK_QUERY,
                blockId,
                userId
        );
    }

    @Override
    public void deleteBlock(long blockId, long userId) {
        jdbc.update(DELETE_BLOCK_QUERY, blockId, userId);
    }

    @Override
    public boolean deleteTasks(long userId) {
        return delete(DELETE_TASK_QUERY, userId);
    }

    @Override
    public boolean deleteBlocks(long userId) {
        return delete(DELETE_BLOCK_QUERY, userId);
    }
}
