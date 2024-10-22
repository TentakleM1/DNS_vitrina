package ru.dns.vitrina.server.epic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.epic.model.Epic;

public interface EpicRepository extends JpaRepository<Epic, Long> {
}
