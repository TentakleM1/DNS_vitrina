package ru.dns.vitrina.server.epic.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dns.vitrina.server.epic.dto.EpicDto;
import ru.dns.vitrina.server.epic.mapper.EpicMapper;
import ru.dns.vitrina.server.epic.model.Epic;
import ru.dns.vitrina.server.epic.model.SuccessEpic;
import ru.dns.vitrina.server.epic.repository.EpicRepository;
import ru.dns.vitrina.server.epic.repository.SuccessEpicRepository;
import ru.dns.vitrina.server.exception.NotFoundException;
import ru.dns.vitrina.server.user.model.User;
import ru.dns.vitrina.server.user.service.UserService;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class EpicServiceImpl implements EpicService {
    private final EpicRepository repository;
    private final SuccessEpicRepository successEpicRepository;
    private final UserService userService;

    @Override
    public void save(EpicDto dto) {
        Epic epic = EpicMapper.mapToEpic(dto);
        Epic saved = repository.save(epic);
        log.info("Saved epic {}", saved);
    }

    @Override
    public void delete(long id) {
        Epic epic = findById(id);
        repository.deleteById(id);
        log.info("Deleted epic {}", id);
    }

    @Override
    public void successEpic(EpicDto dto) {
        SuccessEpic successEpic = EpicMapper.mapToSuccessEpic(dto);
        SuccessEpic saved = successEpicRepository.save(successEpic);
        log.info("Saved epic {}", saved);
    }

    @Override
    public Epic findById(long id) {
        return repository.findById(id).orElseThrow(()-> new NotFoundException("Epic not found"));
    }

    @Override
    public List<EpicDto> findByUserId(long userId) {
        User user = userService.findById(userId);
        return repository.findByUser(user)
                .stream()
                .map(EpicMapper::mapToDto)
                .toList();
    }

    @Override
    public List<EpicDto> findAll() {
        return repository.findAll().stream()
                .map(EpicMapper::mapToDto)
                .toList();
    }

    @Override
    public void successDeleteAll() {
        successEpicRepository.deleteAll();
    }
}
