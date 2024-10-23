package ru.dns.vitrina.server.task.mapper;

import ru.dns.vitrina.server.task.dto.TaskDto;
import ru.dns.vitrina.server.task.model.Task;

public class TaskMapper {
    public static TaskDto mapToTaskDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setName(task.getName());
        return dto;
    }
}
