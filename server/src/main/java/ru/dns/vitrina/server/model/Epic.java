package ru.dns.vitrina.server.model;

import lombok.Data;

@Data
public class Epic {
    private int taskId;
    private long userId;
    private String description;
    private String colorPriority;
}
