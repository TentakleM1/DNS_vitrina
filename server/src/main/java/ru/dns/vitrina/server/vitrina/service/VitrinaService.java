package ru.dns.vitrina.server.vitrina.service;

import ru.dns.vitrina.server.vitrina.dto.VitrinaDto;

import java.util.List;

public interface VitrinaService {
    void save(VitrinaDto dto);

    void update(VitrinaDto dto);

    void delete(int vitrinId);

    List<VitrinaDto> getAll();

    VitrinaDto getById(Integer vitrinId);
}
