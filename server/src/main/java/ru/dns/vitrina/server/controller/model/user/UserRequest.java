package ru.dns.vitrina.server.controller.model.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import ru.dns.vitrina.server.validator.annotation.NotWriteSpace;

@Data
public class UserRequest {
    private Long id;
    @NotBlank(message = "Пустое имя")
    @NotWriteSpace(message = "С пробелами имя")
    private String name;
    @NotBlank(message = "Пустая фамилия")
    @NotWriteSpace(message = "С пробелами фамилия")
    private String lastName;
    @NotBlank(message = "Пустой пароль")
    @NotWriteSpace(message = "С пробелами пароль")
    private String password;
    @NotBlank(message = "Пустое поле рут прав")
    private boolean root;
}
