package ru.dns.vitrina.server.block.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dns.vitrina.server.block.model.Block;
import ru.dns.vitrina.server.block.repository.BlockRepository;
import ru.dns.vitrina.server.block.service.BlockService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BlockServiceImpl implements BlockService {
    private final BlockRepository repository;

    @Override
    public List<Block> getBlocks() {
        return List.of();
    }
}
