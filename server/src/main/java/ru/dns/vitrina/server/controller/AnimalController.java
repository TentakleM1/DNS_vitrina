package ru.dns.vitrina.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dns.vitrina.server.controller.model.animal.AnimalDto;
import ru.dns.vitrina.server.service.inheritance.AnimalService;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService animalService;

    @CrossOrigin
    @GetMapping("/avatars")
    public List<AnimalDto> getAvatars() {
        return animalService.getAll();
    }

    @CrossOrigin
    @GetMapping("/avatar/{animalId}")
    public AnimalDto getAvatar(@PathVariable long animalId) {
        return animalService.get(animalId);
    }

    @CrossOrigin
    @GetMapping("/search-avatar/{userId}")
    public List<AnimalDto> searchAvatar(@PathVariable long userId) {
        return animalService.search(userId);
    }
}
