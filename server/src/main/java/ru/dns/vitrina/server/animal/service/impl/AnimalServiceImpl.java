package ru.dns.vitrina.server.animal.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dns.vitrina.server.animal.model.Animal;
import ru.dns.vitrina.server.animal.repository.AnimalRepository;
import ru.dns.vitrina.server.animal.service.AnimalService;


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
