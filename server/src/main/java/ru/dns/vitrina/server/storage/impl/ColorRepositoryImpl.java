package ru.dns.vitrina.server.storage.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.dns.vitrina.server.model.Color;
import ru.dns.vitrina.server.storage.BaseRepository;
import ru.dns.vitrina.server.storage.inheritance.ColorRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ColorRepositoryImpl extends BaseRepository<Color> implements ColorRepository {
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM colors WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM colors";

    public ColorRepositoryImpl(JdbcTemplate jdbc, RowMapper<Color> mapper) {
        super(jdbc, mapper);
    }

    @Override
    public Optional<Color> findById(long id) {
        return findOne(FIND_BY_ID_QUERY, id);
    }

    @Override
    public List<Color> getAll() {
        return findMany(FIND_ALL_QUERY);
    }
}
