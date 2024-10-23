package ru.dns.vitrina.server.vitrina.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.dns.vitrina.server.vitrina.dto.VitrinaDto;
import ru.dns.vitrina.server.vitrina.service.VitrinaService;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class VitrinaController {
    private final VitrinaService service;

    @CrossOrigin
    @GetMapping("/vitrins")
    public List<VitrinaDto> getAll() {
        log.info("Get all vitrins");
        List<VitrinaDto> vitrinaDtos = service.getAll();
        log.info("Get all vitrins done");
        return vitrinaDtos;
    }

    @CrossOrigin
    @PostMapping("/vitrina-save")
    public void save(@Valid @RequestBody VitrinaDto dto) {
        log.info("Save vitrins {}", dto.toString());
        service.save(dto);
    }

    @CrossOrigin
    @PostMapping("/vitrina-update")
    public void update(@Valid @RequestBody VitrinaDto dto) {
        log.info("Update vitrins {}", dto.toString());
        service.update(dto);
    }

    @CrossOrigin
    @GetMapping("/vitrina/{vitrinId}")
    public VitrinaDto getById(@PathVariable("vitrinId") @NotBlank Integer vitrinId) {
        log.info("Get vitrine {}", vitrinId);
        VitrinaDto dto = service.getById(vitrinId);
        log.info("Get vitrine {} done", dto.toString());
        return dto;
    }

    @CrossOrigin
    @DeleteMapping("/vitrina/{vitrinId}")
    public void delete(@PathVariable("vitrinId") @NotBlank Integer vitrinId) {
        log.info("Delete vitrine {}", vitrinId);
        service.delete(vitrinId);
    }

}
