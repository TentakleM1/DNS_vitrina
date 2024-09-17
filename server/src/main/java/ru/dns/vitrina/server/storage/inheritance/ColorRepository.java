package ru.dns.vitrina.server.storage.inheritance;

import ru.dns.vitrina.server.model.Color;
import ru.dns.vitrina.server.storage.Repository;

import java.util.List;
import java.util.Optional;

public interface ColorRepository extends Repository {
    Optional<Color> findById(long id);

    List<Color> getAll();

    int searchFree();

    List<Color> search(long userId);
}
