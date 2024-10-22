package ru.dns.vitrina.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dns.vitrina.server.controller.dto.task.TaskDto;
import ru.dns.vitrina.server.service.impl.TaskService;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @CrossOrigin
    @GetMapping("/tasks")
    public List<TaskDto> getTasks() {
        return taskService.getAll();
    }

    @CrossOrigin
    @GetMapping("task/{taskId}")
    public TaskDto getTask(@PathVariable Long taskId) {
        return taskService.get(taskId);
    }

    @CrossOrigin
    @GetMapping("/search-task/{userId}")
    public List<TaskDto> searchTask(@PathVariable Long userId) {
        return taskService.search(userId);
    }

}
