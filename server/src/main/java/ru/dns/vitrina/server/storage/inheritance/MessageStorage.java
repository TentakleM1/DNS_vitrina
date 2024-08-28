package ru.dns.vitrina.server.storage.inheritance;

import ru.dns.vitrina.server.model.Message;

import java.util.Map;
import java.util.Optional;

public interface MessageStorage {
    Map<Integer, Message> getAllMessage();

    Optional<Message> getMessage(Integer id);
}
