package ru.dns.vitrina.server.service.inheritance;

import ru.dns.vitrina.server.controller.model.block.BlockDto;
import ru.dns.vitrina.server.controller.model.block.BlockRequest;
import ru.dns.vitrina.server.service.BaseService;

import java.util.List;

public interface BlockService extends BaseService<BlockDto, BlockRequest> {
    List<BlockDto> searchBlock(long userId);
}
