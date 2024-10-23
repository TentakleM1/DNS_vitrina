package ru.dns.vitrina.server.epic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dns.vitrina.server.epic.model.Epic;
import ru.dns.vitrina.server.user.model.User;

import java.util.List;

public interface EpicRepository extends JpaRepository<Epic, Long> {
    List<Epic> findByUser(User user);
}
