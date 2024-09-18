package ru.dns.vitrina.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dns.vitrina.server.controller.model.epic.EpicDto;
import ru.dns.vitrina.server.controller.model.epic.EpicRequest;
import ru.dns.vitrina.server.service.inheritance.EpicService;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EpicController {
    private final EpicService epicService;

    @CrossOrigin
    @GetMapping("/epic-all")
    public List<EpicDto> getAllEpics() {
        return epicService.getAll();
    }

    @CrossOrigin
    @GetMapping("/epic/{userId}")
    public List<EpicDto> getEpicsByUserId(@PathVariable long userId) {
        return epicService.getEpicsUser(userId);
    }

    @CrossOrigin
    @PostMapping("/create-epic")
    public EpicDto createEpic(@RequestBody EpicRequest request) {
        return epicService.save(request);
    }
}
