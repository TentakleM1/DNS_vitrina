package ru.dns.vitrina.server.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import ru.dns.vitrina.server.validator.annotation.NotWriteSpace;
import ru.dns.vitrina.server.validator.annotation.NullOrNotBlank;
import ru.dns.vitrina.server.validator.group.Create;
import ru.dns.vitrina.server.validator.group.Default;
import ru.dns.vitrina.server.validator.group.Update;

@Data
public class User {
    private long id;
    private String name;
    private String lastName;
    private String password;
    private boolean root;
}
