package ru.dns.vitrina.server.block.service;

import ru.dns.vitrina.server.block.dto.BlockDto;

import java.util.List;

public interface BlockService {
    List<BlockDto> findAll();

    BlockDto findById(int id);
}
