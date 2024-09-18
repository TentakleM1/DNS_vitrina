package ru.dns.vitrina.server.service.inheritance;

import ru.dns.vitrina.server.controller.model.epic.EpicDto;
import ru.dns.vitrina.server.controller.model.epic.EpicRequest;
import ru.dns.vitrina.server.service.BaseService;

import java.util.List;

public interface EpicService extends BaseService<EpicDto, EpicRequest> {
    List<EpicDto> getEpicsUser(Long userId);
}
