package ru.dns.vitrina.server.storage.inheritance;

import ru.dns.vitrina.server.model.Block;

import java.util.Map;
import java.util.Optional;

public interface BlockStorage {
    Map<Integer, Block> getAllBlock();

    Optional<Block> getBlock(Integer id);
}
