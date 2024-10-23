package ru.dns.vitrina.server.epic.mapper;

import ru.dns.vitrina.server.epic.dto.EpicDto;
import ru.dns.vitrina.server.epic.model.Epic;
import ru.dns.vitrina.server.epic.model.SuccessEpic;


public class EpicMapper {
    public static EpicDto mapToDto(Epic epic) {
        EpicDto dto = new EpicDto();
        dto.setId(epic.getId());
        dto.setTask(epic.getTask());
        dto.setUser(epic.getUser());
        dto.setDescription(epic.getDescription());
        dto.setColorPriority(epic.getColorPriority());
        return dto;
    }

    public static Epic mapToEpic(EpicDto dto) {
        Epic epic = new Epic();
        epic.setId(dto.getId());
        epic.setTask(dto.getTask());
        epic.setUser(dto.getUser());
        epic.setDescription(dto.getDescription());
        epic.setColorPriority(dto.getColorPriority());
        return epic;
    }

    public static SuccessEpic mapToSuccessEpic(EpicDto dto) {
        SuccessEpic successEpic = new SuccessEpic();
        successEpic.setId(dto.getId());
        successEpic.setTask(dto.getTask());
        successEpic.setUser(dto.getUser());
        successEpic.setDescription(dto.getDescription());
        successEpic.setColorPriority(dto.getColorPriority());
        return successEpic;
    }
}
