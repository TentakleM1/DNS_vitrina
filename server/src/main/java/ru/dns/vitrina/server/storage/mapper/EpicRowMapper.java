package ru.dns.vitrina.server.storage.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.dns.vitrina.server.model.Epic;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EpicRowMapper implements RowMapper<Epic> {
    @Override
    public Epic mapRow(ResultSet rs, int rowNum) throws SQLException {
        Epic epic = new Epic();
        epic.setTaskId(rs.getInt("task_id"));
        epic.setUserId(rs.getInt("user_id"));
        epic.setDescription(rs.getString("description"));
        epic.setColorPriority(rs.getString("color_priority"));
        return epic;
    }
}
