package ru.dns.vitrina.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.model.Vitrina;

public interface VitrinaRepository extends JpaRepository<Vitrina, Integer> {

}
