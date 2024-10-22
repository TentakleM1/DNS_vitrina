package ru.dns.vitrina.server.color.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dns.vitrina.server.color.model.Color;
import ru.dns.vitrina.server.color.repository.ColorRepository;


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
