package ru.dns.vitrina.server.epic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.epic.model.SuccessEpic;

public interface SuccessEpicRepository extends JpaRepository<SuccessEpic, Long> {
}
