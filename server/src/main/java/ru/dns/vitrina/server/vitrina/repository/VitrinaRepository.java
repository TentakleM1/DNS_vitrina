package ru.dns.vitrina.server.vitrina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.vitrina.model.Vitrina;

public interface VitrinaRepository extends JpaRepository<Vitrina, Integer> {

}
