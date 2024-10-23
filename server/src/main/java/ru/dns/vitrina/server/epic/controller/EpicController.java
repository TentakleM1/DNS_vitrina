package ru.dns.vitrina.server.epic.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.dns.vitrina.server.epic.dto.EpicDto;
import ru.dns.vitrina.server.epic.mapper.EpicMapper;
import ru.dns.vitrina.server.epic.service.EpicService;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class EpicController {
    private final EpicService service;

    @CrossOrigin
    @GetMapping("/epics")
    public List<EpicDto> getAllEpics() {
        log.info("getAllEpics");
        List<EpicDto> epicDtos = service.findAll();
        log.info("getAllEpics {}", epicDtos);
        return service.findAll();
    }

    @CrossOrigin
    @GetMapping("/epic/{epicId}")
    public EpicDto getEpicsById(@PathVariable long epicId) {
        log.info("getEpicsById {}", epicId);
        EpicDto dto = EpicMapper.mapToDto(service.findById(epicId));
        log.info("getEpicsById {}", dto);
        return dto;
    }

    @CrossOrigin
    @GetMapping("/epic-user/{userId}")
    public List<EpicDto> getEpicsByUserId(@PathVariable long userId) {
        log.info("getEpicsByUserId {}", userId);
        List<EpicDto> epicDtos = service.findByUserId(userId);
        log.info("getEpicsByUserId {}", epicDtos);
        return epicDtos;
    }

    @CrossOrigin
    @PostMapping("/create-epic")
    public void createEpic(@RequestBody EpicDto dto) {
        log.info("createEpic {}", dto);
        service.save(dto);
    }
}
