package ru.dns.vitrina.server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dns.vitrina.server.model.Animal;
import ru.dns.vitrina.server.service.impl.AnimalService;
import ru.dns.vitrina.server.repository.AnimalRepository;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository repository;


    @Override
    public void update(long userId) {

    }

    @Override
    public Animal searchNullableAnimalUser() {
        return null;
    }
}
