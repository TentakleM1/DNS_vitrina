package ru.dns.vitrina.server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dns.vitrina.server.model.Block;
import ru.dns.vitrina.server.storage.inheritance.BlockStorage;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BlockService {
    private final BlockStorage blockStorage;

    public List<Block> getAllBlock(){
        return blockStorage.getAllBlock();
    }

    public Optional<Block> getBlock(int id) {
        return blockStorage.getBlock(id);
    }
}
