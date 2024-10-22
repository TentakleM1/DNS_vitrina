package ru.dns.vitrina.server.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.user.model.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLastNameAndPassword(String lastName, String password);
}
