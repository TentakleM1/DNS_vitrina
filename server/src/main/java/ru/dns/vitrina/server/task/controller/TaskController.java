package ru.dns.vitrina.server.task.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dns.vitrina.server.task.dto.TaskDto;
import ru.dns.vitrina.server.task.service.TaskService;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class TaskController {
    private final TaskService service;

    @CrossOrigin
    @GetMapping("/tasks")
    public List<TaskDto> getTasks() {
        log.info("Get tasks");
        List<TaskDto> tasks = service.getTasks();
        log.info("Tasks count: {}", tasks);
        return tasks;
    }
}
