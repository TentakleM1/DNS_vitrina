package ru.dns.vitrina.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dns.vitrina.server.controller.mapper.ColorMapper;
import ru.dns.vitrina.server.controller.model.color.ColorDto;
import ru.dns.vitrina.server.controller.model.color.ColorRequest;
import ru.dns.vitrina.server.exception.NotFoundException;
import ru.dns.vitrina.server.service.inheritance.ColorService;
import ru.dns.vitrina.server.storage.inheritance.ColorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {
    private final ColorRepository colorRepository;

    @Override
    public ColorDto get(Long id) {
        return colorRepository.findById(id)
                .map(ColorMapper::mapToColorDto)
                .orElseThrow(() -> new NotFoundException("Цвет с ID = " + id + " не найден"));
    }

    @Override
    public List<ColorDto> getAll() {
        return colorRepository.getAll().stream()
                .map(ColorMapper::mapToColorDto)
                .collect(Collectors.toList());
    }

    @Override
    public ColorDto save(ColorRequest request) {
        return null;
    }

    @Override
    public ColorDto update(ColorRequest request) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
