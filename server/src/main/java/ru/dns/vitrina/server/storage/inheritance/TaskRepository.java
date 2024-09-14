package ru.dns.vitrina.server.storage.inheritance;

import ru.dns.vitrina.server.model.Task;
import ru.dns.vitrina.server.storage.Repository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends Repository {
    Optional<Task> findById(long id);

    List<Task> getAll();


}
