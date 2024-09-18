package ru.dns.vitrina.server.storage.inheritance;

import ru.dns.vitrina.server.model.Epic;
import ru.dns.vitrina.server.storage.Repository;

import java.util.List;
import java.util.Optional;

public interface EpicRepository extends Repository {
    Optional<Epic> findById(long id);

    List<Epic> getAll();

    List<Epic> getEpicsUser(long userId);

    Epic save(Epic epic);

    boolean deleteByIdUser(long userId);
}
