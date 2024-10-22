package ru.dns.vitrina.server.block.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.block.model.Block;

public interface BlockRepository extends JpaRepository<Block, Integer> {
}
