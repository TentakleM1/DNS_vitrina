package ru.dns.vitrina.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dns.vitrina.server.controller.mapper.UserMapper;
import ru.dns.vitrina.server.controller.model.user.UserDto;
import ru.dns.vitrina.server.controller.model.user.UserRequest;
import ru.dns.vitrina.server.exception.NotFoundException;
import ru.dns.vitrina.server.exception.ValidationException;
import ru.dns.vitrina.server.model.User;
import ru.dns.vitrina.server.service.inheritance.UserService;
import ru.dns.vitrina.server.storage.inheritance.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AnimalRepository animalRepository;
    private final BlockRepository blockRepository;
    private final ColorRepository colorRepository;
    private final TaskRepository taskRepository;

    @Override
    public UserDto getUserSign(UserRequest request) {
        User user = UserMapper.mapToUser(request);
        return UserMapper.mapToUserDto(userRepository.getUserSign(user.getLastName(), user.getPassword()));
    }

    @Override
    public void saveTask(long userId, int taskId) {
        taskRepository.findById(taskId);
        get(userId);
        userRepository.saveTask(userId, taskId);
    }

    @Override
    public void deleteTask(long userId, int taskId) {
        taskRepository.findById(taskId);
        get(userId);
        userRepository.deleteTask(userId, taskId);
    }

    @Override
    public void saveBlock(long userId, int blockId) {
        blockRepository.findById(blockId);
        get(userId);
        userRepository.saveBlock(userId, blockId);
    }

    @Override
    public void deleteBlock(long userId, int blockId) {
        blockRepository.findById(blockId);
        get(userId);
        userRepository.deleteBlock(userId, blockId);
    }

    @Override
    public boolean deleteTasks(long userId) {
        get(userId);
        return userRepository.deleteTasks(userId);
    }

    @Override
    public boolean deleteBlocks(long userId) {
        get(userId);
        return userRepository.deleteBlocks(userId);
    }

    @Override
    public UserDto get(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::mapToUserDto)
                .orElseThrow(() -> new NotFoundException("Пользователь с ID = " + id + " не найден"));
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.getAll().stream()
                .map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto save(UserRequest request) {
        User user = UserMapper.mapToUser(request);
        userRepository.saveColor(colorRepository.searchFree(), user.getId());
        userRepository.saveAnimal(animalRepository.searchFree(), user.getId());
        return UserMapper.mapToUserDto(userRepository.save(user));
    }

    @Override
    public UserDto update(UserRequest request) {
        if (request.getId() == null) {
            throw new ValidationException("ID", "Должен быть указан ID");
        }
        User user = UserMapper.mapToUser(request);
        get(user.getId());
        return UserMapper.mapToUserDto(userRepository.update(user));
    }

    @Override
    public boolean delete(Long id) {
        get(id);
        userRepository.deleteColor(id);
        userRepository.deleteAnimal(id);
        deleteBlocks(id);
        deleteTasks(id);
        return userRepository.delete(id);
    }
}
