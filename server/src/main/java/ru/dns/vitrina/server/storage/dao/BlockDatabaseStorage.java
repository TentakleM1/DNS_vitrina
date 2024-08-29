package ru.dns.vitrina.server.storage.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import ru.dns.vitrina.server.model.Block;
import ru.dns.vitrina.server.storage.inheritance.BlockStorage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class BlockDatabaseStorage implements BlockStorage {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Block> getAllBlock() {
        String sqlQuery = "SELECT * FROM block;";
        return jdbcTemplate.query(sqlQuery, this::mapRowToBlock);
    }

    @Override
    public Optional<Block> getBlock(Integer id) {
        String sqlQuery = "SELECT * FROM block WHERE id = ?";
        SqlRowSet blockRows = jdbcTemplate.queryForRowSet(sqlQuery, id);
        if (blockRows.next()) {
            Block block = new Block(blockRows.getInt("id"), blockRows.getString("name"),blockRows.getInt("x"),blockRows.getInt("y"),blockRows.getInt("length"),blockRows.getInt("height"));
            log.info("Найдена витрина с id {}", id);
            return Optional.of(block);
        }
        return Optional.empty();
    }

    private Block mapRowToBlock(ResultSet rs, int rowNum) throws SQLException {
        return new Block(rs.getInt("id"), rs.getString("name"),rs.getInt("x"),rs.getInt("y"),rs.getInt("length"),rs.getInt("height"));
    }
}
