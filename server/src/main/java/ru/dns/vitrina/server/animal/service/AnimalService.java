package ru.dns.vitrina.server.animal.service;


import ru.dns.vitrina.server.animal.dto.AnimalDto;
import ru.dns.vitrina.server.animal.model.Animal;

import java.util.List;

public interface AnimalService {
    List<AnimalDto> findAll();

    AnimalDto findById(int id);

}
