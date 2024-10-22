package ru.dns.vitrina.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.model.Block;

public interface BlockRepository extends JpaRepository<Block, Integer> {
}
