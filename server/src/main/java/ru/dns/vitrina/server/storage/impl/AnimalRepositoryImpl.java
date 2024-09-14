package ru.dns.vitrina.server.storage.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.dns.vitrina.server.model.Animal;
import ru.dns.vitrina.server.storage.BaseRepository;
import ru.dns.vitrina.server.storage.inheritance.AnimalRepository;

import java.util.List;
import java.util.Optional;

@Component
public class AnimalRepositoryImpl extends BaseRepository<Animal> implements AnimalRepository {
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM colors WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM colors";

    public AnimalRepositoryImpl(JdbcTemplate jdbc, RowMapper<Animal> mapper) {
        super(jdbc, mapper);
    }

    @Override
    public List<Animal> getAll() {
        return findMany(FIND_ALL_QUERY);
    }

    @Override
    public Optional<Animal> findById(long id) {
        return findOne(FIND_BY_ID_QUERY, id);
    }
}
