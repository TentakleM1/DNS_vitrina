package ru.dns.vitrina.server.controller.model.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import ru.dns.vitrina.server.validator.annotation.NotWriteSpace;

@Data
public class UserRequest {
    private Long id;
    private String name;
    private String lastName;
    private String password;
    private boolean root;
}
