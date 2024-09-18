package ru.dns.vitrina.server.storage.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.dns.vitrina.server.model.Vitrina;
import ru.dns.vitrina.server.storage.BaseRepository;
import ru.dns.vitrina.server.storage.inheritance.VitrinaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class VitrinaRepositoryImpl extends BaseRepository<Vitrina> implements VitrinaRepository {
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM vitrins WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM vitrins";
    private static final String INSERT_VITRINA_UPDATE =
            """
                    INSERT INTO vitrins_user(vitrina_id, user_id)
                    VALUES(?, ?)
                    """;
    private static final String DELETE_VITRINA_BY_USER = "DELETE FROM vitrins_user WHERE vitrina_id = ? AND user_id = ? ";
    private static final String DELETE_ALL_VITRINS_BY_ID = "DELETE FROM vitrins_user WHERE user_id = ?";

    public VitrinaRepositoryImpl(JdbcTemplate jdbc, RowMapper<Vitrina> mapper) {
        super(jdbc, mapper);
    }

    @Override
    public Optional<Vitrina> findById(long id) {
        return findOne(FIND_BY_ID_QUERY);
    }

    @Override
    public List<Vitrina> findAll() {
        return findMany(FIND_ALL_QUERY);
    }

    @Override
    public void addUser(long userId, long vitrinaId) {
        jdbc.update(INSERT_VITRINA_UPDATE, vitrinaId, userId);
    }

    @Override
    public void removeUser(long userId, long vitrinaId) {
        jdbc.update(DELETE_VITRINA_BY_USER, vitrinaId, userId);
    }

    @Override
    public void removeAllVitrinsByUserId(long userId) {
        jdbc.update(DELETE_ALL_VITRINS_BY_ID,userId);
    }
}
