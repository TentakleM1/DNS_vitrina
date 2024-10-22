package ru.dns.vitrina.server.controller.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.dns.vitrina.server.controller.dto.task.TaskDto;
import ru.dns.vitrina.server.model.Task;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TaskMapper {
    public static TaskDto mapToTaskDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setName(task.getName());
        return dto;
    }
}
