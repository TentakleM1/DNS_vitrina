package ru.dns.vitrina.server.storage.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.dns.vitrina.server.model.Color;
import ru.dns.vitrina.server.storage.BaseRepository;
import ru.dns.vitrina.server.storage.inheritance.ColorRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ColorRepositoryImpl extends BaseRepository<Color> implements ColorRepository {
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM colors WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM colors";
    private static final String SEARCH_FREE_COLOR_QUERY =
            """
                    SELECT c.id AS color_id
                    FROM colors c
                    LEFT JOIN color_user cu ON c.id = cu.color_id
                    WHERE cu.user_id IS NULL
                    LIMIT 1
                    """;
    private static final String SEARCH_QUERY =
            """
                    SELECT colors.id, colors.name
                    FROM colors
                    INNER JOIN colors_user ON colors.id = colors_user.colors_id
                    WHERE colors_user.user_id = ?
                    """;

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

    @Override
    public int searchFree() {
        return Objects.requireNonNull(jdbc.queryForObject(SEARCH_FREE_COLOR_QUERY, mapper)).getId();
    }

    @Override
    public List<Color> search(long userId) {
        return jdbc.query(SEARCH_QUERY, mapper, userId);
    }
}
