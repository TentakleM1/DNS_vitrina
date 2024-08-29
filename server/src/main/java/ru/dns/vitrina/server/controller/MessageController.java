package ru.dns.vitrina.server.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dns.vitrina.server.model.Message;
import ru.dns.vitrina.server.service.MessageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/message")
    public List<Message> getMessages() {
        return messageService.getAllMessage();
    }

}
