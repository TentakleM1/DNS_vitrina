package ru.dns.vitrina.server.block.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.dns.vitrina.server.block.dto.BlockDto;
import ru.dns.vitrina.server.block.model.Block;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BlockMapper {
    public static BlockDto mapToBlockDto(Block block) {
        BlockDto dto = new BlockDto();
        dto.setId(block.getId());
        dto.setX(block.getX());
        dto.setY(block.getY());
        dto.setWidth(block.getWidth());
        dto.setHeight(block.getHeight());
        return dto;
    }
}
