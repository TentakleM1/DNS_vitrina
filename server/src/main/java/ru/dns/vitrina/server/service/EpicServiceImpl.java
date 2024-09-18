package ru.dns.vitrina.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dns.vitrina.server.controller.mapper.EpicMapper;
import ru.dns.vitrina.server.controller.model.epic.EpicDto;
import ru.dns.vitrina.server.controller.model.epic.EpicRequest;
import ru.dns.vitrina.server.exception.NotFoundException;
import ru.dns.vitrina.server.model.Epic;
import ru.dns.vitrina.server.service.inheritance.EpicService;
import ru.dns.vitrina.server.storage.inheritance.EpicRepository;
import ru.dns.vitrina.server.storage.mapper.EpicRowMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EpicServiceImpl implements EpicService {
    private final EpicRepository epicRepository;

    @Override
    public EpicDto get(Long id) {
        return epicRepository.findById(id)
                .map(EpicMapper::mapToEpicDto)
                .orElseThrow(() -> new NotFoundException("Задача с ID" + id + "не найдена"));
    }

    @Override
    public List<EpicDto> getAll() {
        return epicRepository.getAll().stream()
                .map(EpicMapper::mapToEpicDto)
                .collect(Collectors.toList());
    }

    @Override
    public EpicDto save(EpicRequest request) {
        Epic epic = EpicMapper.mapToEpic(request);
        return EpicMapper.mapToEpicDto(epicRepository.save(epic));
    }

    @Override
    public EpicDto update(EpicRequest request) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return epicRepository.deleteByIdUser(id);
    }

    @Override
    public List<EpicDto> getEpicsUser(Long userId) {
        return epicRepository.getEpicsUser(userId).stream()
                .map(EpicMapper::mapToEpicDto)
                .collect(Collectors.toList());
    }
}
