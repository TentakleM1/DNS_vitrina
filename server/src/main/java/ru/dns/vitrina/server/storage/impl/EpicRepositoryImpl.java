package ru.dns.vitrina.server.storage.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.dns.vitrina.server.model.Epic;
import ru.dns.vitrina.server.storage.BaseRepository;
import ru.dns.vitrina.server.storage.inheritance.EpicRepository;
import ru.dns.vitrina.server.storage.mapper.EpicRowMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class EpicRepositoryImpl extends BaseRepository<Epic> implements EpicRepository {
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM tasks_user WHERE user_id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM tasks_user";
    private static final String INSERT_EPIC_QUERY =
            """
                    INSERT INTO tasks_user(tasks_id, user_id,description,color_priority) 
                    VALUES(?, ?, ?, ?)
                    """;

    private static final String DELETE_QUERY = "DELETE FROM tasks_user WHERE user_id = ?";

    public EpicRepositoryImpl(JdbcTemplate jdbc, RowMapper<Epic> mapper) {
        super(jdbc, mapper);
    }

    @Override
    public Optional<Epic> findById(long id) {
        return null;
    }

    @Override
    public List<Epic> getAll() {
        return findMany(FIND_ALL_QUERY);
    }

    @Override
    public List<Epic> getEpicsUser(long userId) {
        return jdbc.query(FIND_BY_ID_QUERY, mapper, userId);
    }

    @Override
    public Epic save(Epic epic) {
        insert(
                INSERT_EPIC_QUERY,
                epic.getTaskId(),
                epic.getUserId(),
                epic.getDescription(),
                epic.getColorPriority()
        );
        return epic;
    }

    @Override
    public boolean deleteByIdUser(long userId) {
        return delete(DELETE_QUERY,userId);
    }

}
