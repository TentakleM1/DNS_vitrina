package ru.dns.vitrina.server.task.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.dns.vitrina.server.task.dto.TaskDto;
import ru.dns.vitrina.server.task.model.Task;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TaskMapper {
    public static TaskDto mapToTaskDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setName(task.getName());
        return dto;
    }
}
