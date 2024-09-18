package ru.dns.vitrina.server.storage.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.dns.vitrina.server.model.Block;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BlockRowMapper implements RowMapper<Block> {
    @Override
    public Block mapRow(ResultSet rs, int rowNum) throws SQLException {
        Block block = new Block();
        block.setId(rs.getInt("id"));
        block.setX(rs.getInt("x"));
        block.setY(rs.getInt("y"));
        block.setWidth(rs.getInt("width"));
        block.setHeight(rs.getInt("height"));
        return block;
    }
}
