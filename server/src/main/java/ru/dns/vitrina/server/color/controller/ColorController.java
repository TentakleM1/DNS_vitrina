package ru.dns.vitrina.server.color.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.dns.vitrina.server.color.dto.ColorDto;
import ru.dns.vitrina.server.color.service.ColorService;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class ColorController {
    private final ColorService service;

    @CrossOrigin
    @GetMapping("/colors")
    public List<ColorDto> getColors() {
        log.info("Get colors");
        List<ColorDto> colorDtos = service.findAll();
        log.info("colors \n{}", colorDtos);
        return colorDtos;
    }

    @CrossOrigin
    @GetMapping("/color/{colorId}")
    public ColorDto getColorById(@PathVariable int colorId) {
        log.info("Get color by id {}", colorId);
        ColorDto colorDto = service.findById(colorId);
        log.info("color \n{}", colorDto);
        return colorDto;
    }

}
