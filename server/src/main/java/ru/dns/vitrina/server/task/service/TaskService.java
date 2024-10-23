package ru.dns.vitrina.server.task.service;


import ru.dns.vitrina.server.task.dto.TaskDto;
import ru.dns.vitrina.server.task.model.Task;

import java.util.List;

public interface TaskService {
    List<TaskDto> getTasks();

    Task findById(int id);
}
