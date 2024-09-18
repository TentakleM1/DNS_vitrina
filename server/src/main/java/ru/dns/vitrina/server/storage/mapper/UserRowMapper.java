package ru.dns.vitrina.server.storage.mapper;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.dns.vitrina.server.model.Animal;
import ru.dns.vitrina.server.model.Color;
import ru.dns.vitrina.server.model.User;
import ru.dns.vitrina.server.model.Vitrina;
import ru.dns.vitrina.server.storage.inheritance.AnimalRepository;
import ru.dns.vitrina.server.storage.inheritance.ColorRepository;
import ru.dns.vitrina.server.storage.inheritance.VitrinaRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserRowMapper implements RowMapper<User> {
    ColorRepository colorRepository;
    AnimalRepository animalRepository;
    VitrinaRepository vitrinaRepository;

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        user.setLastName(rs.getString("last_name"));
        user.setRoot(rs.getBoolean("root"));


        List<Animal> avatar = animalRepository.search(user.getId());
        user.setAvatar(avatar);

        List<Color> color = colorRepository.search(user.getId());
        user.setColor(color);

        List<Vitrina> vitrina = vitrinaRepository.searchVitrinsByUser(user.getId());
        user.setVitrina(vitrina);
        return user;
    }
}
