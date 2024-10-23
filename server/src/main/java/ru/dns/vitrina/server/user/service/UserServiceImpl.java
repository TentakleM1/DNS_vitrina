package ru.dns.vitrina.server.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dns.vitrina.server.exception.NotFoundException;
import ru.dns.vitrina.server.user.dto.RegistrationUserDto;
import ru.dns.vitrina.server.user.dto.SignInUserDto;
import ru.dns.vitrina.server.user.dto.UserDto;
import ru.dns.vitrina.server.user.mapper.UserMapper;
import ru.dns.vitrina.server.user.model.User;
import ru.dns.vitrina.server.user.repository.UserRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    @Transactional
    public void save(RegistrationUserDto dto) {
        User user = UserMapper.mapToUserRegistration(dto);
        User savedUser = repository.save(user);
        log.info("Saved user: {}", savedUser);
    }

    @Override
    public UserDto signInUser(SignInUserDto dto) {
        User signInUser = UserMapper.mapToSignInUser(dto);
        return repository.findByLastNameAndPassword(signInUser.getLastName(), signInUser.getPassword()).stream()
                .map(UserMapper::mapToDto)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    @Transactional
    public void delete(long userId) {
        findById(userId);
        repository.deleteById(userId);
    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAll().stream()
                .map(UserMapper::mapToDto)
                .toList();
    }

    @Override
    public User findById(long userId) {
        return repository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
    }


}
