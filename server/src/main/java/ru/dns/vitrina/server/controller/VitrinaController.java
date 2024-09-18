package ru.dns.vitrina.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dns.vitrina.server.controller.model.vitrina.VitrinaDto;
import ru.dns.vitrina.server.service.inheritance.VitrinaService;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class VitrinaController {
    private final VitrinaService vitrinaService;

    @CrossOrigin
    @GetMapping("/vitrina/{vitrinaId}")
    public VitrinaDto getVitrina(@PathVariable Long vitrinaId) {
        return vitrinaService.get(vitrinaId);
    }

    @CrossOrigin
    @GetMapping("/search-vitrins-user/{userId}")
    public List<VitrinaDto> getVitrinasByUserId(@PathVariable Long userId) {
        return vitrinaService.searchVitrinsByUser(userId);
    }

    @CrossOrigin
    @GetMapping("/vitrins")
    public List<VitrinaDto> getAllVitrins() {
        return vitrinaService.getAll();
    }

    @CrossOrigin
    @PostMapping("/add-user-by-vitrin/{userId}/{vitrinId}")
    public void addUserByVitrin(@PathVariable Long userId, @PathVariable Long vitrinId) {
        vitrinaService.addUser(userId, vitrinId);
    }

    @CrossOrigin
    @DeleteMapping("/remove-user-by-vitrin/{userId}/{vitrinaId}")
    public void removeUserByVitrin(@PathVariable Long userId, @PathVariable Long vitrinId) {
        vitrinaService.removeUser(userId, vitrinId);
    }

    @CrossOrigin
    @DeleteMapping("/remove-all-vitrins-by-user/{userId}")
    public void removeAllVitrinsByUserId(@PathVariable Long userId) {
        vitrinaService.removeAllVitrinsUserId(userId);
    }
}
