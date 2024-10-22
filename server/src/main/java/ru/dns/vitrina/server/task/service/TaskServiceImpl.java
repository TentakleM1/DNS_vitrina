package ru.dns.vitrina.server.task.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dns.vitrina.server.task.model.Task;
import ru.dns.vitrina.server.task.repository.TaskRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    @Override
    public List<Task> getTasks() {
        return List.of();
    }
}
