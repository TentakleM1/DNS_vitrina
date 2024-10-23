package ru.dns.vitrina.server.animal.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dns.vitrina.server.animal.dto.AnimalDto;
import ru.dns.vitrina.server.animal.mapper.AnimalMapper;
import ru.dns.vitrina.server.animal.repository.AnimalRepository;
import ru.dns.vitrina.server.animal.service.AnimalService;
import ru.dns.vitrina.server.exception.NotFoundException;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository repository;


    @Override
    public List<AnimalDto> findAll() {
        return repository.findAll().stream()
                .map(AnimalMapper::mapToAnimalDto)
                .toList();
    }

    @Override
    public AnimalDto findById(int id) {
        return repository.findById(id)
                .map(AnimalMapper::mapToAnimalDto)
                .orElseThrow(()-> new NotFoundException("Animal not found with id: " + id));
    }
}
