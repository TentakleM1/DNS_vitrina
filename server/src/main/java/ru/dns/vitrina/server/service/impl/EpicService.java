package ru.dns.vitrina.server.service.impl;


import ru.dns.vitrina.server.controller.dto.epic.EpicDto;

public interface EpicService {
    void save(EpicDto dto);

    void delete(EpicDto dto);

    void successEpic(EpicDto dto);
}
