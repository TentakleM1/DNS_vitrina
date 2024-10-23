package ru.dns.vitrina.server.block.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.dns.vitrina.server.block.dto.BlockDto;
import ru.dns.vitrina.server.block.service.BlockService;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class BlockController {
    private final BlockService service;

    @CrossOrigin
    @GetMapping("/blocks")
    public List<BlockDto> getBlocks() {
        log.info("Get blocks");
        List<BlockDto> blocks = service.findAll();
        log.info("blocks {} ", blocks);
        return blocks;
    }

    @CrossOrigin
    @GetMapping("/block/{blockId}")
    public BlockDto getBlock(@PathVariable int blockId) {
        log.info("Get block {}", blockId);
        BlockDto dto = service.findById(blockId);
        log.info("block {}", dto);
        return dto;
    }
}
