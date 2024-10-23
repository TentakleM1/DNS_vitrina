package ru.dns.vitrina.server.color.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dns.vitrina.server.color.dto.ColorDto;
import ru.dns.vitrina.server.color.mapper.ColorMapper;
import ru.dns.vitrina.server.color.repository.ColorRepository;
import ru.dns.vitrina.server.exception.NotFoundException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {
    private final ColorRepository repository;

    @Override
    public List<ColorDto> findAll() {
        return repository.findAll()
                .stream()
                .map(ColorMapper::mapToColorDto)
                .toList();
    }

    @Override
    public ColorDto findById(int id) {
        return repository.findById(id)
                .map(ColorMapper::mapToColorDto)
                .orElseThrow(()-> new NotFoundException("Color not found"));
    }
}
