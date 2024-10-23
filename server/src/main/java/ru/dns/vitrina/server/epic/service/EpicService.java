package ru.dns.vitrina.server.epic.service;


import ru.dns.vitrina.server.epic.dto.EpicDto;
import ru.dns.vitrina.server.epic.model.Epic;

import java.util.List;

public interface EpicService {
    void save(EpicDto dto);

    void delete(long id);

    void successEpic(EpicDto dto);

    Epic findById(long id);

    List<EpicDto> findByUserId(long userId);

    List<EpicDto> findAll();

    void successDeleteAll();
}
