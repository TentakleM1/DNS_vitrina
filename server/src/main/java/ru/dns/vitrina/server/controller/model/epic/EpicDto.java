package ru.dns.vitrina.server.controller.model.epic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EpicDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int taskId;
    private long userId;
    private String description;
    private String colorPriority;
}
