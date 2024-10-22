package ru.dns.vitrina.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dns.vitrina.server.controller.dto.user.UserDto;
import ru.dns.vitrina.server.repository.*;
import ru.dns.vitrina.server.service.impl.UserService;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final AnimalRepository animalRepository;
    private final ColorRepository colorRepository;
    private final EpicRepository epicRepository;
    private final VitrinaRepository vitrinaRepository;

    @Override
    public void save(UserDto dto) {

    }

    @Override
    public void delete(long userId) {

    }
}
