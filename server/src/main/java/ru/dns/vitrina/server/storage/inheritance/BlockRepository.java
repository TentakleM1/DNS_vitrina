package ru.dns.vitrina.server.storage.inheritance;

import ru.dns.vitrina.server.model.Block;
import ru.dns.vitrina.server.storage.Repository;

import java.util.List;
import java.util.Optional;

public interface BlockRepository extends Repository {
    Optional<Block> findById(long id);

    List<Block> getAll();
}
