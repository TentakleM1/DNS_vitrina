package ru.dns.vitrina.server.animal.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.dns.vitrina.server.animal.dto.AnimalDto;
import ru.dns.vitrina.server.animal.service.AnimalService;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class AnimalController {
    private final AnimalService service;

    @CrossOrigin
    @GetMapping("/avatars")
    public List<AnimalDto> getAvatars() {
        log.info("Get avatars");
        List<AnimalDto> animalDtos = service.findAll();
        log.info("Get avatars {}", animalDtos);
        return animalDtos;
    }

    @CrossOrigin
    @GetMapping("/avatar/{animalId}")
    public AnimalDto getAvatar(@PathVariable int animalId) {
        log.info("Get avatar {}", animalId);
        AnimalDto animalDto = service.findById(animalId);
        log.info("Get avatar {}", animalDto);
        return animalDto;
    }

}
