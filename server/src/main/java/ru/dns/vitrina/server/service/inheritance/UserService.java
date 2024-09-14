package ru.dns.vitrina.server.service.inheritance;

import ru.dns.vitrina.server.controller.model.user.UserDto;
import ru.dns.vitrina.server.controller.model.user.UserRequest;
import ru.dns.vitrina.server.service.BaseService;

public interface UserService extends BaseService<UserDto, UserRequest> {
    UserDto getUserSign(UserRequest request);

    void saveTask(long userId, int taskId);

    void deleteTask(long userId, int taskId);

    void saveBlock(long userId, int blockId);

    void deleteBlock(long userId, int blockId);

    boolean deleteTasks(long userId);

    boolean deleteBlocks(long userId);

}
