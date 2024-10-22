package ru.dns.vitrina.server.service.impl;

import ru.dns.vitrina.server.controller.dto.vitrina.VitrinaDto;

public interface VitrinaService {
    void save(VitrinaDto dto);

    void update(VitrinaDto dto);

    void delete(int vitrinId);
}
