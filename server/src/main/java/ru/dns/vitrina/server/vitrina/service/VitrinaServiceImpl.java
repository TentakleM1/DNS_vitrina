package ru.dns.vitrina.server.vitrina.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dns.vitrina.server.exception.NotFoundException;
import ru.dns.vitrina.server.user.model.User;
import ru.dns.vitrina.server.vitrina.dto.VitrinaDto;
import ru.dns.vitrina.server.vitrina.mapper.VitrinaMapper;
import ru.dns.vitrina.server.vitrina.model.Vitrina;
import ru.dns.vitrina.server.vitrina.repository.VitrinaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class VitrinaServiceImpl implements VitrinaService {
    private final VitrinaRepository repository;

    @Override
    @Transactional
    public void save(VitrinaDto dto) {
        Vitrina vitrina = VitrinaMapper.mapToVitrina(dto);
        Vitrina savedVitrina = repository.save(vitrina);
        log.info("Saved vitrina: {}", savedVitrina);
    }

    @Override
    @Transactional
    public void update(VitrinaDto dto) {
        Vitrina vitrina = VitrinaMapper.mapToVitrina(dto);
    }

    @Override
    @Transactional
    public void delete(int vitrinId) {
        VitrinaDto vitrina = getById(vitrinId);
        repository.deleteById(vitrinId);
        log.info("Deleted vitrina: {}", vitrina);
    }

    @Override
    public List<VitrinaDto> getAll() {
        return repository.findAll().stream()
                .map(VitrinaMapper::mapToDto)
                .toList();
    }

    @Override
    public VitrinaDto getById(Integer vitrinId) {
        Vitrina vitrina = repository.findById(vitrinId).orElseThrow(() -> new NotFoundException("Витрина не найдена"));
        return VitrinaMapper.mapToDto(vitrina);
    }

    @Override
    public List<Vitrina> getUserVitrins(User user) {
        return repository.findByUser(user);
    }
}
