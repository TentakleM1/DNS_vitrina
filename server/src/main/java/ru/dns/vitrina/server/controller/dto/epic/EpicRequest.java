package ru.dns.vitrina.server.controller.dto.epic;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EpicRequest {
    @NotBlank(message = "Пустой id задачи витрины")
    private int taskId;
    @NotBlank(message = "Пустой id пользователя")
    private long userId;
    private String description;
    private String colorPriority;

}

