package ru.dns.vitrina.server.epic.service;


import ru.dns.vitrina.server.epic.dto.EpicDto;

public interface EpicService {
    void save(EpicDto dto);

    void delete(EpicDto dto);

    void successEpic(EpicDto dto);
}
