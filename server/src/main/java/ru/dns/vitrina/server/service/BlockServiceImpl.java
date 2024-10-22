package ru.dns.vitrina.server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dns.vitrina.server.controller.mapper.BlockMapper;
import ru.dns.vitrina.server.controller.dto.block.BlockDto;
import ru.dns.vitrina.server.controller.dto.block.BlockRequest;
import ru.dns.vitrina.server.exception.NotFoundException;
import ru.dns.vitrina.server.model.Block;
import ru.dns.vitrina.server.service.impl.BlockService;
import ru.dns.vitrina.server.repository.BlockRepository;

import java.util.List;
import java.util.stream.Collectors;

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
