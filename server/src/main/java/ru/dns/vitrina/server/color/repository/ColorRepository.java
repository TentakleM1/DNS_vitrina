package ru.dns.vitrina.server.color.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.color.model.Color;

public interface ColorRepository extends JpaRepository<Color, Integer> {

}
