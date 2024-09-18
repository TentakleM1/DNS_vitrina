package ru.dns.vitrina.server.storage.impl;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.dns.vitrina.server.model.Task;
import ru.dns.vitrina.server.storage.BaseRepository;
import ru.dns.vitrina.server.storage.inheritance.TaskRepository;

import java.util.*;


@Repository
public class TaskRepositoryImpl extends BaseRepository<Task> implements TaskRepository {
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM tasks WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM tasks";
    private static final String SEARCH_QUERY =
            """
                    SELECT t.id, t.name
                    FROM tasks t
                    INNER JOIN tasks_user tu ON t.id = tu.task_id
                    WHERE tu.user_id = ?
                    """;

    public TaskRepositoryImpl(JdbcTemplate jdbc, RowMapper<Task> mapper) {
        super(jdbc, mapper);
    }


    @Override
    public Optional<Task> findById(long id) {
        return findOne(FIND_BY_ID_QUERY, id);
    }

    @Override
    public List<Task> getAll() {
        return findMany(FIND_ALL_QUERY);
    }

    @Override
    public List<Task> search(long userId) {
        return jdbc.query(SEARCH_QUERY, mapper, userId);
    }
}
