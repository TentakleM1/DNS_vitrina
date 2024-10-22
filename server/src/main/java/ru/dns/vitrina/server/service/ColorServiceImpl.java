package ru.dns.vitrina.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dns.vitrina.server.model.Color;
import ru.dns.vitrina.server.service.impl.ColorService;
import ru.dns.vitrina.server.repository.ColorRepository;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ColorServiceImpl implements ColorService {
    private final ColorRepository repository;


    @Override
    public void update(long userId) {

    }

    @Override
    public Color searchNullableColorUser() {
        return null;
    }
}
