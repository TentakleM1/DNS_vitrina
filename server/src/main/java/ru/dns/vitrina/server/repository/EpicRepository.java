package ru.dns.vitrina.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.model.Epic;

public interface EpicRepository extends JpaRepository<Epic, Long> {
}
