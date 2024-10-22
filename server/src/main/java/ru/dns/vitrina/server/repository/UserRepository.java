package ru.dns.vitrina.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
