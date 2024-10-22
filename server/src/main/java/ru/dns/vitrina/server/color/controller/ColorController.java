package ru.dns.vitrina.server.color.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dns.vitrina.server.color.dto.ColorDto;
import ru.dns.vitrina.server.color.service.ColorService;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ColorController {
    private final ColorService colorService;

    @CrossOrigin
    @GetMapping("/colors")
    public List<ColorDto> getColors() {
        return colorService.getAll();
    }

    @CrossOrigin
    @GetMapping("/color/{colorId}")
    public ColorDto getColorById(@PathVariable Long colorId) {
        return colorService.get(colorId);
    }

    @CrossOrigin
    @GetMapping("/search-color/{userId}")
    public List<ColorDto> searchColor(@PathVariable Long userId) {
        return colorService.search(userId);
    }
}
