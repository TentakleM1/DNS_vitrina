package ru.dns.vitrina.server.task.service;


import ru.dns.vitrina.server.task.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();
}
