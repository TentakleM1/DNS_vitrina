package ru.dns.vitrina.server.storage.inheritance;

import ru.dns.vitrina.server.model.User;
import ru.dns.vitrina.server.storage.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Repository {
    Optional<User> findById(long id);

    User save(User user);

    User update(User user);

    boolean delete(long id);

    User getUserSign(String lastName, String password);

    List<User> getAll();

    void saveColor(long colorId, long userId);

    void saveAnimal(long animalId, long userId);

    boolean deleteColor(long userId);

    boolean deleteAnimal(long userId);
}
