package ru.dns.vitrina.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dns.vitrina.server.controller.mapper.VitrinaMapper;
import ru.dns.vitrina.server.controller.model.vitrina.VitrinaDto;
import ru.dns.vitrina.server.controller.model.vitrina.VitrinaRequest;
import ru.dns.vitrina.server.exception.NotFoundException;
import ru.dns.vitrina.server.service.inheritance.VitrinaService;
import ru.dns.vitrina.server.storage.inheritance.VitrinaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VitrinaServiceImpl implements VitrinaService {
    private final VitrinaRepository vitrinaRepository;

    @Override
    public VitrinaDto get(Long id) {
        return vitrinaRepository.findById(id)
                .map(VitrinaMapper::mapToVitrinaDto)
                .orElseThrow(() -> new NotFoundException("Витрина с ID" + id + "не найдена"));
    }

    @Override
    public List<VitrinaDto> getAll() {
        return vitrinaRepository.findAll().stream()
                .map(VitrinaMapper::mapToVitrinaDto)
                .collect(Collectors.toList());
    }

    @Override
    public VitrinaDto save(VitrinaRequest request) {
        return null;
    }

    @Override
    public VitrinaDto update(VitrinaRequest request) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void addUser(long userId, long vitrinaId) {
        vitrinaRepository.addUser(userId, vitrinaId);
    }

    @Override
    public void removeUser(long userId, long vitrinaId) {
        vitrinaRepository.removeUser(userId, vitrinaId);
    }

    @Override
    public void removeAllVitrinsUserId(long userId) {
        vitrinaRepository.removeAllVitrinsByUserId(userId);
    }
}
