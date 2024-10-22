package ru.dns.vitrina.server.epic.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.dns.vitrina.server.controller.dto.epic.EpicRequest;
import ru.dns.vitrina.server.epic.dto.EpicDto;
import ru.dns.vitrina.server.epic.model.Epic;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EpicMapper {
    public static EpicDto mapToEpicDto(Epic epic) {
        EpicDto dto = new EpicDto();
        dto.setTaskId(epic.getTaskId());
        dto.setUserId(epic.getUserId());
        dto.setDescription(epic.getDescription());
        dto.setColorPriority(epic.getColorPriority());
        return dto;
    }

    public static Epic mapToEpic(EpicRequest request) {
        Epic epic = new Epic();
        epic.setTaskId(request.getTaskId());
        epic.setUserId(request.getUserId());
        epic.setDescription(request.getDescription());
        epic.setColorPriority(request.getColorPriority());
        return epic;
    }
}
