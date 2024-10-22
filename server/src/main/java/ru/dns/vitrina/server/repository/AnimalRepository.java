package ru.dns.vitrina.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
