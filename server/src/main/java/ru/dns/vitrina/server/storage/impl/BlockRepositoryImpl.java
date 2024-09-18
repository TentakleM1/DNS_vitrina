package ru.dns.vitrina.server.storage.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.dns.vitrina.server.model.Block;
import ru.dns.vitrina.server.storage.BaseRepository;
import ru.dns.vitrina.server.storage.inheritance.BlockRepository;

import java.util.List;
import java.util.Optional;

@Component
public class BlockRepositoryImpl extends BaseRepository<Block> implements BlockRepository {
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM blocks WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM blocks";

    public BlockRepositoryImpl(JdbcTemplate jdbc, RowMapper<Block> mapper) {
        super(jdbc, mapper);
    }

    @Override
    public Optional<Block> findById(long id) {
        return findOne(FIND_BY_ID_QUERY, id);
    }

    @Override
    public List<Block> getAll() {
        return findMany(FIND_ALL_QUERY);
    }
}
