package ru.dns.vitrina.server.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.task.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
