package ru.dns.vitrina.server.service.inheritance;

import ru.dns.vitrina.server.controller.model.task.TaskDto;
import ru.dns.vitrina.server.controller.model.task.TaskRequest;
import ru.dns.vitrina.server.service.BaseService;

import java.util.List;

public interface TaskService  extends BaseService<TaskDto, TaskRequest> {
    List<TaskDto> search(long userId);
}
