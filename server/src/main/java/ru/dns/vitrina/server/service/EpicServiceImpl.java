package ru.dns.vitrina.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dns.vitrina.server.controller.dto.epic.EpicDto;
import ru.dns.vitrina.server.service.impl.EpicService;
import ru.dns.vitrina.server.repository.EpicRepository;


@Service
@RequiredArgsConstructor
public class EpicServiceImpl implements EpicService {
    private final EpicRepository repository;

    @Override
    public void save(EpicDto dto) {

    }

    @Override
    public void delete(EpicDto dto) {

    }

    @Override
    public void successEpic(EpicDto dto) {

    }
}
