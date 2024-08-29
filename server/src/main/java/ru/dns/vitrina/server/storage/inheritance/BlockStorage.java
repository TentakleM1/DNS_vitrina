package ru.dns.vitrina.server.storage.inheritance;

import ru.dns.vitrina.server.model.Block;

import java.util.List;
import java.util.Optional;

public interface BlockStorage {
    List<Block> getAllBlock();

    Optional<Block> getBlock(Integer id);
}
