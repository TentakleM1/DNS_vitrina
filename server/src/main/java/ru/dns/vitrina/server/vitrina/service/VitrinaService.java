package ru.dns.vitrina.server.vitrina.service;

import ru.dns.vitrina.server.user.model.User;
import ru.dns.vitrina.server.vitrina.dto.VitrinaDto;
import ru.dns.vitrina.server.vitrina.model.Vitrina;

import java.util.List;

public interface VitrinaService {
    void save(VitrinaDto dto);

    void update(VitrinaDto dto);

    void delete(int vitrinId);

    List<VitrinaDto> getAll();

    VitrinaDto getById(Integer vitrinId);

    List<Vitrina> getUserVitrins(User user);
}
