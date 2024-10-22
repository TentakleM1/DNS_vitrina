package ru.dns.vitrina.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
