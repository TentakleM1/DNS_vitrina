package ru.dns.vitrina.server.storage.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.dns.vitrina.server.model.Color;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ColorRowMapper implements RowMapper<Color> {

    @Override
    public Color mapRow(ResultSet rs, int rowNum) throws SQLException {
        Color color = new Color();
        color.setId(rs.getInt("id"));
        color.setColor(rs.getString("color"));
        return color;
    }
}
