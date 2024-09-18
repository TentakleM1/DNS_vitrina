package ru.dns.vitrina.server.storage.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.dns.vitrina.server.model.Animal;
import ru.dns.vitrina.server.storage.BaseRepository;
import ru.dns.vitrina.server.storage.inheritance.AnimalRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class AnimalRepositoryImpl extends BaseRepository<Animal> implements AnimalRepository {
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM animals WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM animals";
    private static final String SEARCH_FREE_ANIMAL_QUERY =
            """
                    SELECT a.id AS animal_id
                    FROM animals a
                    LEFT JOIN animal_user au ON a.id = au.animal_id
                    WHERE au.user_id IS NULL
                    LIMIT 1
                    """;
    private static final String SEARCH_QUERY =
            """
                    SELECT a.id, a.name
                    FROM animals a
                    INNER JOIN animals_user au ON a.id = au.animal_id
                    WHERE au.user_id = ?
                    """;

    public AnimalRepositoryImpl(JdbcTemplate jdbc, RowMapper<Animal> mapper) {
        super(jdbc, mapper);
    }

    @Override
    public List<Animal> getAll() {
        return findMany(FIND_ALL_QUERY);
    }

    @Override
    public int searchFree() {
        return Objects.requireNonNull(jdbc.queryForObject(SEARCH_FREE_ANIMAL_QUERY, mapper)).getId();
    }

    @Override
    public List<Animal> search(long userId) {
        return jdbc.query(SEARCH_QUERY, mapper, userId);
    }

    @Override
    public Optional<Animal> findById(long id) {
        return findOne(FIND_BY_ID_QUERY, id);
    }
}
