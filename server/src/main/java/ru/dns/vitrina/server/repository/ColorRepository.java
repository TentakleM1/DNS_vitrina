package ru.dns.vitrina.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.model.Color;

public interface ColorRepository extends JpaRepository<Color, Integer> {

}
