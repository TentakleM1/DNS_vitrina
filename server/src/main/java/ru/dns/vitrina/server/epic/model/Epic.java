package ru.dns.vitrina.server.epic.model;

import jakarta.persistence.*;
import lombok.*;
import ru.dns.vitrina.server.task.model.Task;
import ru.dns.vitrina.server.user.model.User;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "epics")
public class Epic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String description;

    @Column(name = "color_priority")
    private String colorPriority;
}
