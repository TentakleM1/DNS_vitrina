package ru.dns.vitrina.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ru.dns.vitrina.server.controller.dto.vitrina.VitrinaDto;
import ru.dns.vitrina.server.service.impl.VitrinaService;
import ru.dns.vitrina.server.repository.VitrinaRepository;

@Service
@RequiredArgsConstructor
public class VitrinaServiceImpl implements VitrinaService {
    private final VitrinaRepository repository;

    @Override
    public void save(VitrinaDto dto) {

    }

    @Override
    public void update(VitrinaDto dto) {

    }

    @Override
    public void delete(int vitrinId) {

    }
}
