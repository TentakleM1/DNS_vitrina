package ru.dns.vitrina.server.storage.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.dns.vitrina.server.model.Animal;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AnimalRowMapper implements RowMapper<Animal> {
    @Override
    public Animal mapRow(ResultSet rs, int rowNum) throws SQLException {
        Animal animal = new Animal();
        animal.setId(rs.getInt("id"));
        animal.setName(rs.getString("name"));
        return animal;
    }
}
