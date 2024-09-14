package ru.dns.vitrina.server.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dns.vitrina.server.model.Block;
import ru.dns.vitrina.server.service.BlockService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping
public class BlockController {
    private final BlockService blockService;

    @CrossOrigin
    @GetMapping("/blocks")
    public List<Block> getBlocks() {
        return blockService.getAllBlock();
    }

}
