package ru.dns.vitrina.server.service.inheritance;

import ru.dns.vitrina.server.controller.model.color.ColorDto;
import ru.dns.vitrina.server.controller.model.color.ColorRequest;
import ru.dns.vitrina.server.service.BaseService;

import java.util.List;

public interface ColorService extends BaseService<ColorDto, ColorRequest> {
    List<ColorDto> search(long userId);
}
