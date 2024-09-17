package ru.dns.vitrina.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dns.vitrina.server.controller.mapper.AnimalMapper;
import ru.dns.vitrina.server.controller.model.animal.AnimalDto;
import ru.dns.vitrina.server.controller.model.animal.AnimalRequest;
import ru.dns.vitrina.server.exception.NotFoundException;
import ru.dns.vitrina.server.service.inheritance.AnimalService;
import ru.dns.vitrina.server.storage.inheritance.AnimalRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;


    @Override
    public AnimalDto get(Long id) {
        return animalRepository.findById(id)
                .map(AnimalMapper::mapToAnimalDto)
                .orElseThrow(() -> new NotFoundException("Аватар животного с ID = " + id + " не найден"));
    }

    @Override
    public List<AnimalDto> getAll() {
        return animalRepository.getAll().stream()
                .map(AnimalMapper::mapToAnimalDto)
                .collect(Collectors.toList());
    }

    @Override
    public AnimalDto save(AnimalRequest request) {
        return null;
    }

    @Override
    public AnimalDto update(AnimalRequest request) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<AnimalDto> search(long userId) {
        return animalRepository.search(userId).stream()
                .map(AnimalMapper::mapToAnimalDto)
                .collect(Collectors.toList());
    }
}
