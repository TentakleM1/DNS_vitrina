package ru.dns.vitrina.server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dns.vitrina.server.model.Message;
import ru.dns.vitrina.server.storage.inheritance.MessageStorage;

import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageService {
    private final MessageStorage messageStorage;

    public Map<Integer, Message> getAllMessage(){
        return messageStorage.getAllMessage();
    }

    public Optional<Message> getMessage(int id) {
        return messageStorage.getMessage(id);
    }
}
