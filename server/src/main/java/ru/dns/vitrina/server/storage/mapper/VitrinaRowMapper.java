package ru.dns.vitrina.server.storage.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.dns.vitrina.server.model.Vitrina;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class VitrinaRowMapper implements RowMapper<Vitrina> {
    @Override
    public Vitrina mapRow(ResultSet rs, int rowNum) throws SQLException {
        Vitrina vitrina = new Vitrina();
        vitrina.setId(rs.getInt("id"));
        vitrina.setName(rs.getString("name"));
        vitrina.setBlockId(rs.getInt("block_id"));
        return vitrina;
    }
}
