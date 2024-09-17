package ru.dns.vitrina.server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dns.vitrina.server.controller.mapper.BlockMapper;
import ru.dns.vitrina.server.controller.model.block.BlockDto;
import ru.dns.vitrina.server.controller.model.block.BlockRequest;
import ru.dns.vitrina.server.exception.NotFoundException;
import ru.dns.vitrina.server.service.inheritance.BlockService;
import ru.dns.vitrina.server.storage.inheritance.BlockRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BlockServiceImpl implements BlockService {
    private final BlockRepository blockRepository;

    @Override
    public BlockDto get(Long id) {
        return blockRepository.findById(id)
                .map(BlockMapper::mapToBlockDto)
                .orElseThrow(() -> new NotFoundException("Блок с ID = " + id + " не найден"));
    }

    @Override
    public List<BlockDto> getAll() {
        return blockRepository.getAll().stream()
                .map(BlockMapper::mapToBlockDto)
                .collect(Collectors.toList());
    }

    @Override
    public BlockDto save(BlockRequest request) {
        return null;
    }

    @Override
    public BlockDto update(BlockRequest request) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<BlockDto> searchBlock(long userId) {
        return blockRepository.search(userId).stream()
                .map(BlockMapper::mapToBlockDto)
                .collect(Collectors.toList());
    }
}
