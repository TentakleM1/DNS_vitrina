package ru.dns.vitrina.server.storage.inheritance;

import ru.dns.vitrina.server.model.Animal;
import ru.dns.vitrina.server.storage.Repository;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends Repository {
    Optional<Animal> findById(long id);

    List<Animal> getAll();

    int searchFree();
}
