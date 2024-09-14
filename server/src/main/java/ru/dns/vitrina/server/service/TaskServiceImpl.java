package ru.dns.vitrina.server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dns.vitrina.server.controller.mapper.TaskMapper;
import ru.dns.vitrina.server.controller.model.task.TaskDto;
import ru.dns.vitrina.server.controller.model.task.TaskRequest;
import ru.dns.vitrina.server.exception.NotFoundException;
import ru.dns.vitrina.server.model.Task;
import ru.dns.vitrina.server.service.inheritance.TaskService;
import ru.dns.vitrina.server.storage.inheritance.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;


    @Override
    public TaskDto get(Long id) {
        return taskRepository.findById(id)
                .map(TaskMapper::mapToTaskDto)
                .orElseThrow(() -> new NotFoundException("Задача с ID = " + id + " не найден"));
    }

    @Override
    public List<TaskDto> getAll() {
        return taskRepository.getAll().stream()
                .map(TaskMapper::mapToTaskDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto save(TaskRequest request) {
        return null;
    }

    @Override
    public TaskDto update(TaskRequest request) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
