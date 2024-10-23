package ru.dns.vitrina.server.vitrina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.user.model.User;
import ru.dns.vitrina.server.vitrina.model.Vitrina;

import java.util.List;

public interface VitrinaRepository extends JpaRepository<Vitrina, Integer> {
    List<Vitrina> findByUser(User user);
}
