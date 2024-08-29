package ru.dns.vitrina.server.storage.inheritance;

import ru.dns.vitrina.server.model.Message;

import java.util.List;
import java.util.Optional;

public interface MessageStorage {
    List<Message> getAllMessage();

    Optional<Message> getMessage(Integer id);
}
