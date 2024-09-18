package ru.dns.vitrina.server.service.inheritance;

import ru.dns.vitrina.server.controller.model.vitrina.VitrinaDto;
import ru.dns.vitrina.server.controller.model.vitrina.VitrinaRequest;
import ru.dns.vitrina.server.service.BaseService;

public interface VitrinaService extends BaseService<VitrinaDto, VitrinaRequest> {
    void addUser(long userId, long vitrinaId);

    void removeUser(long userId, long vitrinaId);

    void removeAllVitrinsUserId(long userId);
}
