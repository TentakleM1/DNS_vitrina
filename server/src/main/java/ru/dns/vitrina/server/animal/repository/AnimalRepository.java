package ru.dns.vitrina.server.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.animal.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
