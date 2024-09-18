package ru.dns.vitrina.server.storage.inheritance;

import ru.dns.vitrina.server.model.Vitrina;
import ru.dns.vitrina.server.storage.Repository;

import java.util.List;
import java.util.Optional;

public interface VitrinaRepository extends Repository {
    Optional<Vitrina> findById(long id);

    List<Vitrina> findAll();

    void addUser(long userId, long vitrinaId);

    void removeUser(long userId, long vitrinaId);

    void removeAllVitrinsByUserId(long userId);

    List<Vitrina> searchVitrinsByUser(long userId);
}
