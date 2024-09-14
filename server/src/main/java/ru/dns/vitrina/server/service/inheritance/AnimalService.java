package ru.dns.vitrina.server.service.inheritance;

import ru.dns.vitrina.server.controller.model.animal.AnimalDto;
import ru.dns.vitrina.server.controller.model.animal.AnimalRequest;
import ru.dns.vitrina.server.service.BaseService;

public interface AnimalService extends BaseService<AnimalDto, AnimalRequest> {
}
