package ru.dns.vitrina.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dns.vitrina.server.controller.model.block.BlockDto;
import ru.dns.vitrina.server.service.inheritance.BlockService;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BlockController {
    private final BlockService blockService;

    @CrossOrigin
    @GetMapping("/blocks")
    public List<BlockDto> getBlocks() {
        return blockService.getAll();
    }

    @CrossOrigin
    @GetMapping("/block/{blockId}")
    public BlockDto getBlock(@PathVariable Long blockId) {
        return blockService.get(blockId);
    }

    @CrossOrigin
    @GetMapping("/search-block/{userId}")
    public List<BlockDto> searchBlock(@PathVariable Long userId) {
        return blockService.searchBlock(userId);
    }

}
