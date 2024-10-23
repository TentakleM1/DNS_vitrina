package ru.dns.vitrina.server.epic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dns.vitrina.server.task.model.Task;
import ru.dns.vitrina.server.user.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpicDto {
    private long id;
    private Task task;
    private User user;
    private String description;
    private String colorPriority;
}
