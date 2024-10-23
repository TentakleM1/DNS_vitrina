package ru.dns.vitrina.server.block.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dns.vitrina.server.block.dto.BlockDto;
import ru.dns.vitrina.server.block.mapper.BlockMapper;
import ru.dns.vitrina.server.block.model.Block;
import ru.dns.vitrina.server.block.repository.BlockRepository;
import ru.dns.vitrina.server.block.service.BlockService;
import ru.dns.vitrina.server.exception.NotFoundException;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BlockServiceImpl implements BlockService {
    private final BlockRepository repository;

    @Override
    public List<BlockDto> findAll() {
        return repository.findAll().stream()
                .map(BlockMapper::mapToBlockDto)
                .toList();
    }

    @Override
    public BlockDto findById(int id) {
        return repository.findById(id)
                .map(BlockMapper::mapToBlockDto)
                .orElseThrow(()-> new NotFoundException("Block not found"));
    }
}
