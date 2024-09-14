package ru.dns.vitrina.server.storage.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.dns.vitrina.server.model.Task;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TaskRowMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setId(rs.getInt("id"));
        task.setName(rs.getString("name"));
        return task;
    }
}
